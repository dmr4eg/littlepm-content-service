package pm.little.contentservice.exceptions;

import pm.little.api.models.ids.FormFieldMapperId;
import pm.little.api.models.ids.FormInstanceId;

public class FormInstanceNotFoundException extends RuntimeException {
    public FormInstanceNotFoundException(FormInstanceId id) {
        super("Form Instance not found with ID: " + id);
    }
}