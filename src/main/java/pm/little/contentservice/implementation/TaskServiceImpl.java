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

    @Autowired
    private TaskBlueprintRepository taskBlueprintRepository;

    @Autowired
    private TaskInstanceRepository taskInstanceRepository;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public TaskBlueprint createTaskBlueprint(TaskBlueprint blueprint) {
        return taskBlueprintRepository.save(blueprint);
    }

    @Override
    public TaskBlueprint getTaskBlueprint(UUID taskBlueprintUuid) {
        return taskBlueprintRepository.findById(taskBlueprintUuid)
                .orElseThrow(() -> new TaskBlueprintNotFoundException(taskBlueprintUuid));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public TaskBlueprint updateTaskBlueprint(UUID taskBlueprintUuid, TaskBlueprint blueprint) {
        TaskBlueprint existing = getTaskBlueprint(taskBlueprintUuid);
        existing.setTitle(blueprint.getTitle());
        existing.setDescription(blueprint.getDescription());
        return taskBlueprintRepository.save(existing);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTaskBlueprint(UUID taskBlueprintUuid) {
        taskBlueprintRepository.deleteById(taskBlueprintUuid);
    }

    @Override
    public List<TaskBlueprint> listTaskBlueprints(int limit, int offset) {
        return taskBlueprintRepository.findAll(PageRequest.of(offset/limit, limit)).getContent();
    }

    @Override
    public TaskInstance createTaskInstance(TaskInstance instance) {
        return taskInstanceRepository.save(instance);
    }

    @Override
    public TaskInstance getTaskInstance(UUID taskBlueprintUuid, UUID userUuid) {
        TaskInstanceId id = new TaskInstanceId()
                .taskBlueprintUuid(taskBlueprintUuid)
                .userUuid(userUuid);
        return taskInstanceRepository.findById(id)
                .orElseThrow(() -> new TaskInstanceNotFoundException(id));
    }

    @Override
    public TaskInstance updateTaskStatus(UUID taskBlueprintUuid, UUID userUuid, boolean status) {
        TaskInstance instance = getTaskInstance(taskBlueprintUuid, userUuid);
        instance.setStatus(status);
        return taskInstanceRepository.save(instance);
    }
}