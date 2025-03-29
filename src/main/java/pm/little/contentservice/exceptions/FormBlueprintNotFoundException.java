package pm.little.contentservice.exceptions;

import pm.little.api.models.FormBlueprint;
import pm.little.api.models.ids.FormInstanceId;

import java.util.UUID;

public class FormBlueprintNotFoundException extends RuntimeException {
    public FormBlueprintNotFoundException(UUID id) {
        super("Form Blueprint not found with ID: " + id);
    }
}