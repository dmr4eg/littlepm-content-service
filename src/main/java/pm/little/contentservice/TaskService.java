package pm.little.contentservice;

import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import pm.little.api.models.TaskBlueprint;
import pm.little.api.models.TaskInstance;
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

    public TaskInstance createTaskInstance(TaskInstance instance) ;

    public TaskInstance getTaskInstance(UUID taskBlueprintUuid, UUID userUuid) ;

    public TaskInstance updateTaskStatus(UUID taskBlueprintUuid, UUID userUuid, boolean status) ;

}
