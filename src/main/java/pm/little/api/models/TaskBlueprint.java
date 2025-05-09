package pm.little.api.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;

/**
 * TaskBlueprint
 */
@Entity
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-27T23:47:32.256351+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class TaskBlueprint {
  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID taskBlueprintUuid;

  private String title;

  private @Nullable String description;

  public TaskBlueprint() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TaskBlueprint(UUID taskBlueprintUuid, String title) {
    this.taskBlueprintUuid = taskBlueprintUuid;
    this.title = title;
  }

  public TaskBlueprint taskBlueprintUuid(UUID taskBlueprintUuid) {
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

  public TaskBlueprint title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @NotNull 
  @Schema(name = "title", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public TaskBlueprint description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskBlueprint taskBlueprint = (TaskBlueprint) o;
    return Objects.equals(this.taskBlueprintUuid, taskBlueprint.taskBlueprintUuid) &&
        Objects.equals(this.title, taskBlueprint.title) &&
        Objects.equals(this.description, taskBlueprint.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskBlueprintUuid, title, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskBlueprint {\n");
    sb.append("    taskBlueprintUuid: ").append(toIndentedString(taskBlueprintUuid)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

