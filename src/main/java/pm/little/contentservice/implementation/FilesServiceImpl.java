package pm.little.contentservice.implementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pm.little.contentservice.FilesService;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FilesServiceImpl implements FilesService {
    @Value("${file.storage-dir:./uploads}")
    private String storageDir;

    @Override
    public URI storeFile(MultipartFile file, UUID mediaUuid) throws IOException {
        String extension = getFileExtension(file.getOriginalFilename());
        String filename = mediaUuid + extension;
        Path targetLocation = Paths.get(storageDir).resolve(filename);
        Files.createDirectories(targetLocation.getParent());
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return URI.create("/media/" + filename);
    }

    @Override
    public void deleteFile(URI fileUri) {
        try {
            Path filePath = Paths.get(storageDir, fileUri.getPath().replaceFirst("/media/files/", ""));
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete file: " + fileUri, e);
        }
    }

    @Override
    public String getFileExtension(String filename) {
        if (filename == null || filename.lastIndexOf(".") == -1) {
            return "";
        }
        return filename.substring(filename.lastIndexOf("."));
    }
}
