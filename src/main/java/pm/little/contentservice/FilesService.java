package pm.little.contentservice;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public interface FilesService {
     
    public URI storeFile(MultipartFile file, UUID mediaUuid) throws IOException ;

    public void deleteFile(URI fileUri) ;

    public String getFileExtension(String filename) ;
}
