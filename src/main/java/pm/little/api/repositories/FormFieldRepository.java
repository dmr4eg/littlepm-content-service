package pm.little.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pm.little.api.models.FormField;

import java.util.UUID;

public interface FormFieldRepository extends JpaRepository<FormField, UUID> {
}
