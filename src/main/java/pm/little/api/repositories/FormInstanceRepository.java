package pm.little.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pm.little.api.models.FormInstance;

import java.util.UUID;

public interface FormInstanceRepository extends JpaRepository<FormInstance, UUID> {
}
