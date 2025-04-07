package pm.little.contentservice;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import pm.little.api.models.Media;
import pm.little.api.models.enums.TypeEnum;
import pm.little.contentservice.exceptions.MediaNotFoundException;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.UUID;

public interface MediaService {

    public List<Media> getAllMedia(int limit, int offset) ;

    public Media getMediaById(UUID mediaUuid) ;

    @Transactional
    public void deleteMedia(UUID mediaUuid) ;

    public Media updateMedia(UUID mediaUuid, Media mediaDetails) ;

    @Transactional
    public Media createMedia(MultipartFile file, String title, TypeEnum type, String description) throws IOException ;

    public List<Media> listMedia(int limit, int offset) ;
}
