package pm.little.contentservice.exceptions;

import pm.little.api.models.ids.*;

public class FormFieldNotFoundException extends RuntimeException {
    public FormFieldNotFoundException(FormFieldMapperId id) {
        super("Form Field not found with ID: " + id);
    }
}