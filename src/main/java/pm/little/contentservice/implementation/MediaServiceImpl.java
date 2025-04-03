package pm.little.contentservice.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pm.little.api.models.Media;
import pm.little.contentservice.MediaService;
import pm.little.api.repositories.*;
import pm.little.contentservice.exceptions.MediaNotFoundException;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Service
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;

    public MediaServiceImpl(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    public Media uploadMedia(MultipartFile file, Media metadata) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Uploaded file is empty");
        }

        // For demonstration, let's pretend you store it at /uploads/<filename>.
        // In reality, you might use Amazon S3, local disk, etc.
        String filename = file.getOriginalFilename();
        // storeTheFileSomewhere(file, filename);

        // Possibly generate a random UUID
        if (metadata.getMediaUUID() == null) {
            metadata.setMediaUUID(UUID.randomUUID());
        }

        // Maybe store the URL or path
        metadata.setUrl(URI.create("/uploads/" + filename));

        // Save the DB record
        return mediaRepository.save(metadata);
    }

    @Override
    public Media getMedia(UUID mediaUuid) {
        return mediaRepository.findById(mediaUuid)
                .orElseThrow(() -> new MediaNotFoundException(mediaUuid));
    }

    @Override
    public Media updateMedia(UUID mediaUuid, Media media) {
        Media existing = getMedia(mediaUuid);
        existing.setTitle(media.getTitle());
        existing.setDescription(media.getDescription());
        existing.setType(media.getType());
        return mediaRepository.save(existing);
    }

    @Override
    public void deleteMedia(UUID mediaUuid) {
        Media media = getMedia(mediaUuid);
        mediaRepository.delete(media);
    }

    @Override
    public List<Media> listMedia(int limit, int offset) {
        return mediaRepository.findAll(PageRequest.of(offset/limit, limit)).getContent();
    }
}