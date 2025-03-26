package pm.little.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.lang.Nullable;

import io.swagger.v3.oas.annotations.media.Schema;




/**
 * TaskInstance
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-26T00:36:51.210059+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class TaskInstance {

  private @Nullable UUID taskBlueprintUuid;

  private @Nullable UUID userUuid;

  private @Nullable Boolean status;

  public TaskInstance taskBlueprintUuid(UUID taskBlueprintUuid) {
    this.taskBlueprintUuid = taskBlueprintUuid;
    return this;
  }

  /**
   * Get taskBlueprintUuid
   * @return taskBlueprintUuid
   */
  @Valid
  @Schema(name = "task_blueprint_uuid", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("task_blueprint_uuid")
  public UUID getTaskBlueprintUuid() {
    return taskBlueprintUuid;
  }

  public void setTaskBlueprintUuid(UUID taskBlueprintUuid) {
    this.taskBlueprintUuid = taskBlueprintUuid;
  }

  public TaskInstance userUuid(UUID userUuid) {
    this.userUuid = userUuid;
    return this;
  }

  /**
   * Get userUuid
   * @return userUuid
   */
  @Valid 
  @Schema(name = "user_uuid", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("user_uuid")
  public UUID getUserUuid() {
    return userUuid;
  }

  public void setUserUuid(UUID userUuid) {
    this.userUuid = userUuid;
  }

  public TaskInstance status(Boolean status) {
    this.status = status;
    return this;
  }

  /**
   * True if completed, false otherwise
   * @return status
   */
  
  @Schema(name = "status", description = "True if completed, false otherwise", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskInstance taskInstance = (TaskInstance) o;
    return Objects.equals(this.taskBlueprintUuid, taskInstance.taskBlueprintUuid) &&
        Objects.equals(this.userUuid, taskInstance.userUuid) &&
        Objects.equals(this.status, taskInstance.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskBlueprintUuid, userUuid, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskInstance {\n");
    sb.append("    taskBlueprintUuid: ").append(toIndentedString(taskBlueprintUuid)).append("\n");
    sb.append("    userUuid: ").append(toIndentedString(userUuid)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

