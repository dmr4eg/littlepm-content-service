package pm.little.contentservice.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
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

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskBlueprintRepository taskBlueprintRepository;
    private final TaskInstanceRepository taskInstanceRepository;

    public TaskServiceImpl(
            TaskBlueprintRepository taskBlueprintRepository,
            TaskInstanceRepository taskInstanceRepository
    ) {
        this.taskBlueprintRepository = taskBlueprintRepository;
        this.taskInstanceRepository = taskInstanceRepository;
    }

    @Override
    public TaskBlueprint createTaskBlueprint(TaskBlueprint blueprint) {
        TaskBlueprint existing = taskBlueprintRepository.findById(blueprint.getTaskBlueprintUuid()).orElse(null);
        if (existing != null) {
            return existing;
        }
        return taskBlueprintRepository.save(blueprint);
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
    public TaskBlueprint updateTaskBlueprint(UUID taskBlueprintUuid, TaskBlueprint blueprint) {
        if (!taskBlueprintRepository.existsById(taskBlueprintUuid)) {
            throw new TaskBlueprintNotFoundException(taskBlueprintUuid);
        }
        TaskBlueprint existing = getTaskBlueprint(taskBlueprintUuid);
        existing.setTitle(blueprint.getTitle());
        existing.setDescription(blueprint.getDescription());
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

    @Override
    public TaskInstance createTaskInstance(TaskInstance instance) {
        TaskInstance existing = taskInstanceRepository.findById(instance.getId()).orElse(null);
        if (existing != null) {
            return existing;
        }
        return taskInstanceRepository.save(instance);
    }

    @Override
    public TaskInstance getTaskInstance(UUID taskBlueprintUuid, UUID userUuid) {
        TaskInstanceId id = new TaskInstanceId(taskBlueprintUuid, userUuid);
        if (!taskInstanceRepository.existsById(id)) {
            throw new TaskInstanceNotFoundException(id);
        }
        return taskInstanceRepository.findById(id)
                .orElseThrow(() -> new TaskInstanceNotFoundException(id));
    }

    @Override
    public TaskInstance updateTaskStatus(UUID taskBlueprintUuid, UUID userUuid, boolean status) {
        TaskInstanceId id = new TaskInstanceId(taskBlueprintUuid, userUuid);
        if (!taskInstanceRepository.existsById(id)) {
            throw new TaskInstanceNotFoundException(id);
        }
        TaskInstance instance = getTaskInstance(taskBlueprintUuid, userUuid);
        instance.setStatus(status);
        return taskInstanceRepository.save(instance);
    }
}