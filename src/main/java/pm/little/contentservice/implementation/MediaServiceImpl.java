package pm.little.contentservice.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pm.little.api.models.Media;
import pm.little.contentservice.MediaService;
import pm.little.api.repositories.*;
import pm.little.contentservice.exceptions.MediaNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Media uploadMedia(MultipartFile file, Media metadata) {
        String mediaUuid = UUID.randomUUID().toString();
        String fileUrl = mediaRepository.store(file, mediaUuid);

        metadata.setMediaUUID(mediaUuid);
        metadata.setUrl(fileUrl);
        return mediaRepository.save(metadata);
    }

    @Override
    public Media getMedia(UUID mediaUuid) {
        return mediaRepository.findById(mediaUuid)
                .orElseThrow(() -> new MediaNotFoundException(mediaUuid));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Media updateMedia(UUID mediaUuid, Media media) {
        Media existing = getMedia(mediaUuid);
        existing.setTitle(media.getTitle());
        existing.setDescription(media.getDescription());
        existing.setType(media.getType());
        return mediaRepository.save(existing);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteMedia(UUID mediaUuid) {
        Media media = getMedia(mediaUuid);
        mediaRepository.delete(media);
    }

    @Override
    public List<Media> listMedia(int limit, int offset) {
        return mediaRepository.findAll(PageRequest.of(offset/limit, limit)).getContent();
    }
}