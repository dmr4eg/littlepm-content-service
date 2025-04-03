package pm.little.api.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import pm.little.api.controllers.TasksApi;
import pm.little.api.models.TaskBlueprint;
import pm.little.contentservice.TaskService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("${openapi.some-base-path:}") // Adjust path if needed
public class TasksApiController implements TasksApi {

    private final NativeWebRequest request;
    private final TaskService taskService;

    @Autowired
    public TasksApiController(NativeWebRequest request, TaskService taskService) {
        this.request = request;
        this.taskService = taskService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /**
     * GET /tasks?limit=...&offset=...
     * List task templates
     */
    @Override
    public ResponseEntity<List<TaskBlueprint>> tasksGet(Integer limit, Integer offset) {
        List<TaskBlueprint> tasks = taskService.listTaskBlueprints(limit, offset);
        return ResponseEntity.ok(tasks);
    }

    /**
     * POST /tasks
     * Create task template (admin only)
     */
    @Override
    public ResponseEntity<TaskBlueprint> tasksPost(TaskBlueprint taskBlueprint) {
        TaskBlueprint created = taskService.createTaskBlueprint(taskBlueprint);
        return ResponseEntity.ok(created);
    }

    /**
     * GET /tasks/{task_blueprint_uuid}
     * Get task template
     */
    @Override
    public ResponseEntity<TaskBlueprint> tasksTaskBlueprintUuidGet(UUID taskBlueprintUuid) {
        TaskBlueprint blueprint = taskService.getTaskBlueprint(taskBlueprintUuid);
        return ResponseEntity.ok(blueprint);
    }

    /**
     * PUT /tasks/{task_blueprint_uuid}
     * Update task template (admin only)
     */
    @Override
    public ResponseEntity<TaskBlueprint> tasksTaskBlueprintUuidPut(UUID taskBlueprintUuid, TaskBlueprint taskBlueprint) {
        TaskBlueprint updated = taskService.updateTaskBlueprint(taskBlueprintUuid, taskBlueprint);
        return ResponseEntity.ok(updated);
    }

    /**
     * DELETE /tasks/{task_blueprint_uuid}
     * Delete task template (admin only)
     */
    @Override
    public ResponseEntity<Void> tasksTaskBlueprintUuidDelete(UUID taskBlueprintUuid) {
        taskService.deleteTaskBlueprint(taskBlueprintUuid);
        return ResponseEntity.noContent().build();
    }
}
