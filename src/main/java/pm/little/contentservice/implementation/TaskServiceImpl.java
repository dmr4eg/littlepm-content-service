package pm.little.contentservice.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pm.little.api.models.*;
import pm.little.api.models.ids.*;
import pm.little.contentservice.TaskService;
import pm.little.api.models.dto.*;
import pm.little.api.repositories.*;
import pm.little.contentservice.exceptions.TaskBlueprintNotFoundException;
import pm.little.contentservice.exceptions.TaskInstanceNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskBlueprintRepository taskBlueprintRepository;
    private final TaskInstanceRepository taskInstanceRepository;

    public TaskServiceImpl(
            TaskBlueprintRepository taskBlueprintRepository,
            TaskInstanceRepository taskInstanceRepository) {
        this.taskBlueprintRepository = taskBlueprintRepository;
        this.taskInstanceRepository = taskInstanceRepository;
    }

    @Override
    public TaskBlueprint createTaskBlueprint(TaskBlueprint taskBlueprint) {
        TaskBlueprint existing = taskBlueprintRepository.findById(taskBlueprint.getTaskBlueprintUuid()).orElse(null);
        if (existing != null) {
            return existing;
        }
        return taskBlueprintRepository.save(taskBlueprint);
    }

    @Override
    public TaskBlueprint getTaskBlueprint(UUID taskBlueprintUuid) {
        if (!taskBlueprintRepository.existsById(taskBlueprintUuid)) {
            throw new TaskBlueprintNotFoundException(taskBlueprintUuid);
        }
        return taskBlueprintRepository.findById(taskBlueprintUuid)
                .orElseThrow(() -> new TaskBlueprintNotFoundException(taskBlueprintUuid));
    }

    @Override
    public TaskBlueprint updateTaskBlueprint(UUID taskBlueprintUuid, TaskBlueprint taskBlueprint) {
        if (!taskBlueprintRepository.existsById(taskBlueprintUuid)) {
            throw new TaskBlueprintNotFoundException(taskBlueprintUuid);
        }
        TaskBlueprint existing = getTaskBlueprint(taskBlueprintUuid);
        existing.setTitle(taskBlueprint.getTitle());
        existing.setDescription(taskBlueprint.getDescription());
        return taskBlueprintRepository.save(existing);
    }

    @Override
    public void deleteTaskBlueprint(UUID taskBlueprintUuid) {
        if (!taskBlueprintRepository.existsById(taskBlueprintUuid)) {
            throw new TaskBlueprintNotFoundException(taskBlueprintUuid);
        }
        taskBlueprintRepository.deleteById(taskBlueprintUuid);
    }

    @Override
    public List<TaskBlueprint> listTaskBlueprints(int limit, int offset) {
        PageRequest pageable = PageRequest.of(offset, limit);
        return taskBlueprintRepository.findAll(pageable).getContent();
    }

    private TaskDTO toTaskDTO(TaskInstance taskInstance) {
        TaskInstanceId taskInstanceId = taskInstance.getId();
        UUID taskBlueprintUuid = taskInstanceId.getTaskBlueprintUuid();
        if (!taskInstanceRepository.existsById(taskInstanceId)) {
            throw new TaskInstanceNotFoundException(taskInstanceId);
        }
        TaskBlueprint taskBlueprint = taskBlueprintRepository.findById(taskBlueprintUuid)
                .orElseThrow(() -> new TaskBlueprintNotFoundException(taskBlueprintUuid));

        TaskDTO dto = new TaskDTO();
        dto.setBlueprint(taskBlueprint);
        dto.setProgress(taskInstance);
        return dto;
    }

    @Override
    public TaskDTO createTaskInstance(TaskInstance taskInstance) {
        TaskInstanceId taskInstanceId = taskInstance.getId();
        UUID taskBlueprintUuid = taskInstanceId.getTaskBlueprintUuid();
        if (!taskInstanceRepository.existsById(taskInstanceId)) {
            throw new TaskInstanceNotFoundException(taskInstanceId);
        }
        if (!taskBlueprintRepository.existsById(taskBlueprintUuid)) {
            throw new TaskBlueprintNotFoundException(taskBlueprintUuid);
        }
        TaskInstance existing = taskInstanceRepository.findById(taskInstance.getId()).orElse(null);
        if (existing != null) {
            return toTaskDTO(existing);
        }
        TaskInstance saved = taskInstanceRepository.save(taskInstance);
        return toTaskDTO(saved);
    }

    @Override
    public TaskDTO getTaskInstance(UUID taskBlueprintUuid, UUID userUuid) {
        if (!taskBlueprintRepository.existsById(taskBlueprintUuid)) {
            throw new TaskBlueprintNotFoundException(taskBlueprintUuid);
        }
        TaskInstanceId taskInstanceId = new TaskInstanceId(taskBlueprintUuid, userUuid);
        TaskInstance instance = taskInstanceRepository.findById(taskInstanceId)
                .orElseThrow(() -> new TaskInstanceNotFoundException(taskInstanceId));
        return toTaskDTO(instance);
    }

    /**
     * If you prefer a partial update for the status only, rename or keep as-is,
     * but the return type should be TaskDTO.
     */
    @Override
    public TaskDTO updateTaskStatus(UUID taskBlueprintUuid, UUID userUuid, boolean status) {
        if (!taskBlueprintRepository.existsById(taskBlueprintUuid)) {
            throw new TaskBlueprintNotFoundException(taskBlueprintUuid);
        }
        TaskInstanceId taskInstanceId = new TaskInstanceId(taskBlueprintUuid, userUuid);
        if (!taskInstanceRepository.existsById(taskInstanceId)) {
            throw new TaskInstanceNotFoundException(taskInstanceId);
        }
        TaskInstance instance = getRawTaskInstance(taskBlueprintUuid, userUuid); // see helper below
        instance.setStatus(status);
        TaskInstance saved = taskInstanceRepository.save(instance);
        return toTaskDTO(saved);
    }

    /**
     * A method that does a full update from a TaskInstance object.
     */
    @Override
    public TaskDTO updateTaskInstance(UUID taskBlueprintUuid, UUID userUuid, TaskInstance updated) {
        if (!taskBlueprintRepository.existsById(taskBlueprintUuid)) {
            throw new TaskBlueprintNotFoundException(taskBlueprintUuid);
        }
        TaskInstanceId taskInstanceId = new TaskInstanceId(taskBlueprintUuid, userUuid);
        if (!taskInstanceRepository.existsById(taskInstanceId)) {
            throw new TaskInstanceNotFoundException(taskInstanceId);
        }
        TaskInstance existing = getRawTaskInstance(taskBlueprintUuid, userUuid);
        existing.setStatus(updated.getStatus());
        TaskInstance saved = taskInstanceRepository.save(existing);
        return toTaskDTO(saved);
    }

    @Override
    public void deleteTaskInstance(UUID taskBlueprintUuid, UUID userUuid) {
        if (!taskBlueprintRepository.existsById(taskBlueprintUuid)) {
            throw new TaskBlueprintNotFoundException(taskBlueprintUuid);
        }
        TaskInstanceId taskInstanceId = new TaskInstanceId(taskBlueprintUuid, userUuid);
        if (!taskInstanceRepository.existsById(taskInstanceId)) {
            throw new TaskInstanceNotFoundException(taskInstanceId);
        }
        taskInstanceRepository.deleteById(taskInstanceId);
    }

    /**
     * If you want your list to return TaskDTO,
     * either do a separate method (below) or map in the controller.
     */
    @Override
    public List<TaskInstance> listTaskInstances(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset, limit);
        return taskInstanceRepository.findAll(pageable).getContent();
    }

    @Override
    public List<TaskDTO> listTaskInstancesAsDTO(int limit, int offset) {
        return listTaskInstances(limit, offset)
                .stream()
                .map(this::toTaskDTO)
                .collect(Collectors.toList());
    }

    private TaskInstance getRawTaskInstance(UUID taskBlueprintUuid, UUID userUuid) {
        if (!taskBlueprintRepository.existsById(taskBlueprintUuid)) {
            throw new TaskBlueprintNotFoundException(taskBlueprintUuid);
        }
        TaskInstanceId taskInstanceId = new TaskInstanceId(taskBlueprintUuid, userUuid);
        return taskInstanceRepository.findById(taskInstanceId)
                .orElseThrow(() -> new TaskInstanceNotFoundException(taskInstanceId));
    }

}