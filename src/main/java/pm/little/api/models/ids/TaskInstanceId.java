package pm.little.api.models.ids;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;
import jakarta.annotation.Generated;
import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;



/**
 * Composite ID for TaskInstance
 */
@Embeddable
@Schema(name = "TaskInstanceId", description = "Composite ID for TaskInstance")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-27T23:47:32.256351+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class TaskInstanceId {

  private UUID taskBlueprintUuid;

  private UUID userUuid;

  public TaskInstanceId() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TaskInstanceId(UUID taskBlueprintUuid, UUID userUuid) {
    this.taskBlueprintUuid = taskBlueprintUuid;
    this.userUuid = userUuid;
  }

  public TaskInstanceId taskBlueprintUuid(UUID taskBlueprintUuid) {
    this.taskBlueprintUuid = taskBlueprintUuid;
    return this;
  }

  /**
   * UUID for a Task Blueprint
   * @return taskBlueprintUuid
   */
  @NotNull @Valid 
  @Schema(name = "task_blueprint_uuid", description = "UUID for a Task Blueprint", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("task_blueprint_uuid")
  public UUID getTaskBlueprintUuid() {
    return taskBlueprintUuid;
  }

  public void setTaskBlueprintUuid(UUID taskBlueprintUuid) {
    this.taskBlueprintUuid = taskBlueprintUuid;
  }

  public TaskInstanceId userUuid(UUID userUuid) {
    this.userUuid = userUuid;
    return this;
  }

  /**
   * UUID for a User
   * @return userUuid
   */
  @NotNull @Valid 
  @Schema(name = "user_uuid", description = "UUID for a User", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("user_uuid")
  public UUID getUserUuid() {
    return userUuid;
  }

  public void setUserUuid(UUID userUuid) {
    this.userUuid = userUuid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskInstanceId taskInstanceId = (TaskInstanceId) o;
    return Objects.equals(this.taskBlueprintUuid, taskInstanceId.taskBlueprintUuid) &&
        Objects.equals(this.userUuid, taskInstanceId.userUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskBlueprintUuid, userUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskInstanceId {\n");
    sb.append("    taskBlueprintUuid: ").append(toIndentedString(taskBlueprintUuid)).append("\n");
    sb.append("    userUuid: ").append(toIndentedString(userUuid)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

