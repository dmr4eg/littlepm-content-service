package pm.little.api.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import pm.little.api.controllers.TaskInstancesApi;
import pm.little.api.models.TaskInstance;
import pm.little.api.models.dto.TaskDTO;
import pm.little.contentservice.TaskService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("${openapi.some-base-path:}") // Adjust path if needed
public class TaskInstancesApiController implements TaskInstancesApi {

    private final NativeWebRequest request;
    private final TaskService taskService;

    @Autowired
    public TaskInstancesApiController(NativeWebRequest request, TaskService taskService) {
        this.request = request;
        this.taskService = taskService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /**
     * GET /task-instances
     * List all task instances (return as TaskDTO)
     */
    @Override
    public ResponseEntity<List<TaskDTO>> taskInstancesGet(
            UUID userUuid,
            Integer limit,
            Integer offset
    ) {
        List<TaskDTO> dtos = taskService.listTaskInstancesAsDTO(limit, offset);
        return ResponseEntity.ok(dtos);
    }

    /**
     * POST /task-instances
     * Create a new task instance, returning TaskDTO
     */
    @Override
    public ResponseEntity<TaskDTO> taskInstancesPost(TaskInstance taskInstance) {
        TaskDTO createdDto = taskService.createTaskInstance(taskInstance);
        return ResponseEntity.ok(createdDto);
    }

    /**
     * GET /task-instances/{task_blueprint_uuid}/{user_uuid}
     * Get a user's specific task instance (as TaskDTO)
     */
    @Override
    public ResponseEntity<TaskDTO> taskInstancesTaskBlueprintUuidUserUuidGet(
            UUID taskBlueprintUuid,
            UUID userUuid
    ) {
        TaskDTO dto = taskService.getTaskInstance(taskBlueprintUuid, userUuid);
        return ResponseEntity.ok(dto);
    }

    /**
     * PUT /task-instances/{task_blueprint_uuid}/{user_uuid}
     * Update a task instance
     */
    @Override
    public ResponseEntity<TaskDTO> taskInstancesTaskBlueprintUuidUserUuidPut(
            UUID taskBlueprintUuid,
            UUID userUuid,
            TaskInstance taskInstance
    ) {
        TaskDTO updatedDto = taskService.updateTaskStatus(taskBlueprintUuid, userUuid, taskInstance.getStatus());
        return ResponseEntity.ok(updatedDto);
    }

    /**
     * DELETE /task-instances/{task_blueprint_uuid}/{user_uuid}
     * Delete a task instance
     */
    @Override
    public ResponseEntity<Void> taskInstancesTaskBlueprintUuidUserUuidDelete(
            UUID taskBlueprintUuid,
            UUID userUuid
    ) {
         taskService.deleteTaskInstance(taskBlueprintUuid, userUuid);
         return ResponseEntity.noContent().build();
    }
}
