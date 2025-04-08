package pm.little.api.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import pm.little.api.controllers.MediaApi;
import pm.little.api.models.Media;
import pm.little.api.models.enums.TypeEnum;
import pm.little.contentservice.MediaService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("${openapi.some-base-path:}") // Adjust if needed
public class MediaApiController implements MediaApi {

    private final NativeWebRequest request;
    private final MediaService mediaService;

    @Autowired
    public MediaApiController(NativeWebRequest request, MediaService mediaService) {
        this.request = request;
        this.mediaService = mediaService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /**
     * GET /media?limit=...&offset=...
     * (Optional) List media items
     */
    @Override
    public ResponseEntity<List<Media>> mediaGet(Integer limit, Integer offset) {
        if (limit == null || offset == null) {
            return ResponseEntity.badRequest().build();
        }
        List<Media> mediaList = mediaService.listMedia(limit, offset);
        return ResponseEntity.ok(mediaList);
    }

    /**
     * POST /media
     * (Upload new media metadata, admin only)
     */
    @Override
    public ResponseEntity<Media> mediaPostMultipart(MultipartFile file, String title, String type, String description) throws IOException {
        if (type == null || TypeEnum.fromValue(type) == null) {
            return ResponseEntity.badRequest().build();
        }
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if (file.getSize() > 10 * 1024 * 1024) { // 10 MB limit
            return ResponseEntity.badRequest().build();
        }
        String contentType = file.getContentType();
        if (contentType == null || (!contentType.startsWith("image/") && !contentType.startsWith("video/"))) {
            return ResponseEntity.badRequest().build();
        }
        if (type.equals("image")) {
            type = "IMAGE";
        } else if (type.equals("video")) {
            type = "VIDEO";
        }
        Media media = mediaService.createMedia(file, title, TypeEnum.valueOf(type), description);
        return ResponseEntity.ok(media);
    }


    /**
     * GET /media/{media_uuid}
     * Get media metadata
     */
    @Override
    public ResponseEntity<Media> mediaMediaUuidGet(UUID mediaUuid) {
        if (mediaUuid == null) {
            throw new IllegalArgumentException("Media UUID cannot be null");
        }
        Media found = mediaService.getMediaById(mediaUuid);
        return ResponseEntity.ok(found);
    }

    /**
     * PUT /media/{media_uuid}
     * Update media metadata (admin only)
     */
    @Override
    public ResponseEntity<Media> mediaMediaUuidPut(UUID mediaUuid, Media media) {
        if (mediaUuid == null || media == null) {
            return ResponseEntity.badRequest().build();
        }
        Media updated = mediaService.updateMedia(mediaUuid, media);
        return ResponseEntity.ok(updated);
    }

    /**
     * DELETE /media/{media_uuid}
     * Delete media (admin only)
     */
    @Override
    public ResponseEntity<Void> mediaMediaUuidDelete(UUID mediaUuid) {
        if (mediaUuid == null) {
            return ResponseEntity.badRequest().build();
        }
        mediaService.deleteMedia(mediaUuid);
        return ResponseEntity.noContent().build();
    }
}
