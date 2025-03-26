package pm.little.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pm.little.api.models.TaskBlueprint;

import java.util.UUID;

public interface TaskBlueprintRepository extends JpaRepository<TaskBlueprint, UUID> {
}
