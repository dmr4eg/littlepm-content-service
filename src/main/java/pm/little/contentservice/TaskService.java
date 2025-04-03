package pm.little.contentservice;

import org.springframework.data.domain.PageRequest;
import pm.little.api.models.TaskBlueprint;
import pm.little.api.models.TaskInstance;
import pm.little.api.models.dto.TaskDTO;
import pm.little.api.models.ids.TaskInstanceId;
import pm.little.contentservice.exceptions.TaskBlueprintNotFoundException;
import pm.little.contentservice.exceptions.TaskInstanceNotFoundException;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    public TaskBlueprint createTaskBlueprint(TaskBlueprint blueprint) ;

    public TaskBlueprint getTaskBlueprint(UUID taskBlueprintUuid) ;

    public TaskBlueprint updateTaskBlueprint(UUID taskBlueprintUuid, TaskBlueprint blueprint) ;

    public void deleteTaskBlueprint(UUID taskBlueprintUuid) ;

    public List<TaskBlueprint> listTaskBlueprints(int limit, int offset) ;

    public TaskDTO createTaskInstance(TaskInstance instance) ;

    public TaskDTO getTaskInstance(UUID taskBlueprintUuid, UUID userUuid) ;

    public TaskDTO updateTaskStatus(UUID taskBlueprintUuid, UUID userUuid, boolean status) ;

    public List<TaskInstance> listTaskInstances(int limit, int offset);

    public List<TaskDTO> listTaskInstancesAsDTO(int limit, int offset);

    public TaskDTO updateTaskInstance(UUID taskBlueprintUuid, UUID userUuid, TaskInstance updated);

    public void deleteTaskInstance(UUID taskBlueprintUuid, UUID userUuid);
}
