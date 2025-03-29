package pm.little.contentservice.exceptions;

import pm.little.api.models.ids.FormInstanceId;
import pm.little.api.models.ids.TaskInstanceId;

public class TaskInstanceNotFoundException extends RuntimeException {
    public TaskInstanceNotFoundException(TaskInstanceId id) {
        super("Task Instance not found with ID: " + id);
    }
}