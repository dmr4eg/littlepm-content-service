package pm.little.contentservice.exceptions;

import java.util.UUID;

public class TaskBlueprintNotFoundException extends RuntimeException {
    public TaskBlueprintNotFoundException(UUID id) {
        super("Task Blueprint not found with ID: " + id);
    }
}