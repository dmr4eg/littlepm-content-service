package pm.little.contentservice;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;
import pm.little.api.models.Media;
import pm.little.contentservice.exceptions.MediaNotFoundException;

import java.util.List;
import java.util.UUID;

public interface MediaService {

    public Media uploadMedia(MultipartFile file, Media metadata) ;

    public Media getMedia(UUID mediaUuid) ;

    public Media updateMedia(UUID mediaUuid, Media media) ;

    public void deleteMedia(UUID mediaUuid) ;

    public List<Media> listMedia(int limit, int offset) ;

}
