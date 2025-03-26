package pm.little.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pm.little.api.models.FormBlueprint;

import java.util.UUID;

public interface FormBlueprintRepository extends JpaRepository<FormBlueprint, UUID> {
}
