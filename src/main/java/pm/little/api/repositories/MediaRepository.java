package pm.little.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pm.little.api.models.Media;

import java.util.UUID;

public interface MediaRepository extends JpaRepository<Media, UUID> {
}
