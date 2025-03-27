package pm.little.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pm.little.api.models.FormFieldMapper;

import java.util.UUID;

public interface FormFieldMapperRepository extends JpaRepository<FormFieldMapper, UUID> {
}
