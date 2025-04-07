package pm.little.contentservice.exceptions;

import pm.little.api.models.ids.*;

import java.util.UUID;

public class FormFieldNotFoundException extends RuntimeException {
    public FormFieldNotFoundException(FormFieldMapperId id) {
        super("Form Field not found with ID: " + id);
    }

    public FormFieldNotFoundException(UUID fieldUuid) {
        super("Form Field not found with ID: " + fieldUuid);
    }
}