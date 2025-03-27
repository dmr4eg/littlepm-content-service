package pm.little.api.models.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import pm.little.api.models.TaskBlueprint;
import pm.little.api.models.TaskInstance;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;



/**
 * TaskDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-27T23:47:32.256351+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class TaskDTO {

  private TaskBlueprint blueprint;

  private TaskInstance progress;

  public TaskDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TaskDTO(TaskBlueprint blueprint, TaskInstance progress) {
    this.blueprint = blueprint;
    this.progress = progress;
  }

  public TaskDTO blueprint(TaskBlueprint blueprint) {
    this.blueprint = blueprint;
    return this;
  }

  /**
   * Get blueprint
   * @return blueprint
   */
  @NotNull @Valid 
  @Schema(name = "blueprint", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("blueprint")
  public TaskBlueprint getBlueprint() {
    return blueprint;
  }

  public void setBlueprint(TaskBlueprint blueprint) {
    this.blueprint = blueprint;
  }

  public TaskDTO progress(TaskInstance progress) {
    this.progress = progress;
    return this;
  }

  /**
   * Get progress
   * @return progress
   */
  @NotNull @Valid 
  @Schema(name = "progress", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("progress")
  public TaskInstance getProgress() {
    return progress;
  }

  public void setProgress(TaskInstance progress) {
    this.progress = progress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskDTO taskDTO = (TaskDTO) o;
    return Objects.equals(this.blueprint, taskDTO.blueprint) &&
        Objects.equals(this.progress, taskDTO.progress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blueprint, progress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskDTO {\n");
    sb.append("    blueprint: ").append(toIndentedString(blueprint)).append("\n");
    sb.append("    progress: ").append(toIndentedString(progress)).append("\n");
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

