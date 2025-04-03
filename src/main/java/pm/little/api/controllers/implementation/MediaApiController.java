package pm.little.api.controllers.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import pm.little.api.controllers.MediaApi;
import pm.little.api.models.Media;
import pm.little.contentservice.MediaService;

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
        List<Media> mediaList = mediaService.listMedia(limit, offset);
        return ResponseEntity.ok(mediaList);
    }

    /**
     * POST /media
     * (Upload new media metadata, admin only)
     *
     * Note: The OpenAPI spec only provides a JSON body with `Media`.
     * If you want to handle actual file upload, your spec needs a
     * multipart/form-data endpoint with a file param.
     */


    /**
     * GET /media/{media_uuid}
     * Get media metadata
     */
    @Override
    public ResponseEntity<Media> mediaMediaUuidGet(UUID mediaUuid) {
        Media found = mediaService.getMedia(mediaUuid);
        return ResponseEntity.ok(found);
    }

    /**
     * PUT /media/{media_uuid}
     * Update media metadata (admin only)
     */
    @Override
    public ResponseEntity<Media> mediaMediaUuidPut(UUID mediaUuid, Media media) {
        Media updated = mediaService.updateMedia(mediaUuid, media);
        return ResponseEntity.ok(updated);
    }

    /**
     * DELETE /media/{media_uuid}
     * Delete media (admin only)
     */
    @Override
    public ResponseEntity<Void> mediaMediaUuidDelete(UUID mediaUuid) {
        mediaService.deleteMedia(mediaUuid);
        return ResponseEntity.noContent().build();
    }
}
