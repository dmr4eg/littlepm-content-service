package pm.little.contentservice.exceptions;

import java.util.UUID;

public class MediaNotFoundException extends RuntimeException {
    public MediaNotFoundException(UUID id) {
        super("Media not found with ID: " + id);
    }
}