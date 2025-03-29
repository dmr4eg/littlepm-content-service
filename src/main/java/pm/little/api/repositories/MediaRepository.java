package pm.little.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import pm.little.api.models.Media;

import java.util.UUID;

@Repository
@RepositoryRestResource(exported = false)
public interface MediaRepository extends JpaRepository<Media, UUID> {
    String store(MultipartFile file, String mediaUuid);
}
