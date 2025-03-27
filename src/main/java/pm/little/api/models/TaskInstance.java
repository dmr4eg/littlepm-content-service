package pm.little.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import pm.little.api.models.ids.TaskInstanceId;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * User&#39;s progress for a specific task
 */

@Entity
@Schema(name = "TaskInstance", description = "User's progress for a specific task")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-27T23:47:32.256351+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class TaskInstance {
  @EmbeddedId
  private TaskInstanceId id;

  private Boolean status;

  public TaskInstance() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TaskInstance(TaskInstanceId id, Boolean status) {
    this.id = id;
    this.status = status;
  }

  public TaskInstance id(TaskInstanceId id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @NotNull @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public TaskInstanceId getId() {
    return id;
  }

  public void setId(TaskInstanceId id) {
    this.id = id;
  }

  public TaskInstance status(Boolean status) {
    this.status = status;
    return this;
  }

  /**
   * True if completed, false otherwise
   * @return status
   */
  @NotNull 
  @Schema(name = "status", description = "True if completed, false otherwise", requiredMode = Schema.RequiredMode.REQUIRED)
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
    return Objects.equals(this.id, taskInstance.id) &&
        Objects.equals(this.status, taskInstance.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskInstance {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

