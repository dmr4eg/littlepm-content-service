package pm.little.contentservice.implementation;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pm.little.api.models.Media;
import pm.little.api.models.enums.TypeEnum;
import pm.little.contentservice.FilesService;
import pm.little.contentservice.MediaService;
import pm.little.api.repositories.*;
import pm.little.contentservice.exceptions.MediaNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@Service
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;
    private final FilesService filesService;

    public MediaServiceImpl(MediaRepository mediaRepository, FilesService filesService) {
        this.mediaRepository = mediaRepository;
        this.filesService = filesService;
    }
    
    @Override
    public List<Media> getAllMedia(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset, limit);
        return mediaRepository.findAll(pageable).getContent();
    }

    @Override
    public Media getMediaById(UUID mediaUuid) {
        return mediaRepository.findById(mediaUuid)
                .orElseThrow(() -> new MediaNotFoundException(mediaUuid));
    }

    @Override
    @Transactional
    public void deleteMedia(UUID mediaUuid) {
        if (!mediaRepository.existsById(mediaUuid)) {
            throw new MediaNotFoundException(mediaUuid);
        }
        Media media = getMediaById(mediaUuid);
        mediaRepository.delete(media);
        filesService.deleteFile(media.getUrl());
    }

    @Override
    public Media updateMedia(UUID mediaUuid, Media mediaDetails) {
        if (!mediaRepository.existsById(mediaUuid)) {
            throw new MediaNotFoundException(mediaUuid);
        }
        Media existingMedia = getMediaById(mediaUuid);

        existingMedia.setTitle(mediaDetails.getTitle());
        existingMedia.setDescription(mediaDetails.getDescription());
        existingMedia.setType(mediaDetails.getType());

        return mediaRepository.save(existingMedia);
    }

    @Override
    @Transactional
    public Media createMedia(MultipartFile file, String title, TypeEnum type, String description) throws IOException {
        UUID mediaUUID = UUID.randomUUID();
        URI url = filesService.storeFile(file, mediaUUID);
        Media media = new Media();
        media.setMediaUUID(mediaUUID);
        media.setTitle(title);
        media.setType(type);
        media.setDescription(description);
        media.setUrl(url);

        return mediaRepository.save(media);
    }

    @Override
    public List<Media> listMedia(int limit, int offset) {
        return mediaRepository.findAll(PageRequest.of(offset/limit, limit)).getContent();
    }
}