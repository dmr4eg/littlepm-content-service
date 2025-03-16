package pm.little.api.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;

/**
 * Task
 */

public class Task {

  private UUID taskUUID;

  private UUID projectUUID;

  private String title;

  private UUID blueprintUUID;

  private @Nullable String description;

  /**
   * Gets or Sets day
   */
  public enum DayEnum {
    MONDAY("MONDAY"),
    
    TUESDAY("TUESDAY"),
    
    WEDNESDAY("WEDNESDAY"),
    
    THURSDAY("THURSDAY"),
    
    FRIDAY("FRIDAY"),
    
    SATURDAY("SATURDAY"),
    
    SUNDAY("SUNDAY");

    private String value;

    DayEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DayEnum fromValue(String value) {
      for (DayEnum b : DayEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private @Nullable DayEnum day;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    PENDING("pending"),
    
    IN_PROGRESS("in_progress"),
    
    COMPLETED("completed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime dueDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime createdAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime updatedAt;

  public Task() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Task(UUID taskUUID, UUID projectUUID, String title, UUID blueprintUUID, StatusEnum status) {
    this.taskUUID = taskUUID;
    this.projectUUID = projectUUID;
    this.title = title;
    this.blueprintUUID = blueprintUUID;
    this.status = status;
  }

  public Task taskUUID(UUID taskUUID) {
    this.taskUUID = taskUUID;
    return this;
  }

  /**
   * Get taskUUID
   * @return taskUUID
   */
  @NotNull
  @Valid
  @Schema(name = "taskUUID", example = "550e8400-e29b-41d4-a716-446655440000", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("taskUUID")
  public UUID getTaskUUID() {
    return taskUUID;
  }

  public void setTaskUUID(UUID taskUUID) {
    this.taskUUID = taskUUID;
  }

  public Task projectUUID(UUID projectUUID) {
    this.projectUUID = projectUUID;
    return this;
  }

  /**
   * Get projectUUID
   * @return projectUUID
   */
  @NotNull @Valid 
  @Schema(name = "projectUUID", example = "550e8400-e29b-41d4-a716-446655440000", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("projectUUID")
  public UUID getProjectUUID() {
    return projectUUID;
  }

  public void setProjectUUID(UUID projectUUID) {
    this.projectUUID = projectUUID;
  }

  public Task title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @NotNull 
  @Schema(name = "title", example = "Competitor Analysis", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Task blueprintUUID(UUID blueprintUUID) {
    this.blueprintUUID = blueprintUUID;
    return this;
  }

  /**
   * Get blueprintUUID
   * @return blueprintUUID
   */
  @NotNull @Valid 
  @Schema(name = "blueprintUUID", example = "550e8400-e29b-41d4-a716-446655440000", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("blueprintUUID")
  public UUID getBlueprintUUID() {
    return blueprintUUID;
  }

  public void setBlueprintUUID(UUID blueprintUUID) {
    this.blueprintUUID = blueprintUUID;
  }

  public Task description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", example = "Research main competitors' features", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Task day(DayEnum day) {
    this.day = day;
    return this;
  }

  /**
   * Get day
   * @return day
   */
  
  @Schema(name = "day", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("day")
  public DayEnum getDay() {
    return day;
  }

  public void setDay(DayEnum day) {
    this.day = day;
  }

  public Task status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @NotNull 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Task dueDate(OffsetDateTime dueDate) {
    this.dueDate = dueDate;
    return this;
  }

  /**
   * Get dueDate
   * @return dueDate
   */
  @Valid 
  @Schema(name = "dueDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dueDate")
  public OffsetDateTime getDueDate() {
    return dueDate;
  }

  public void setDueDate(OffsetDateTime dueDate) {
    this.dueDate = dueDate;
  }

  public Task createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
   */
  @Valid 
  @Schema(name = "createdAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Task updatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Get updatedAt
   * @return updatedAt
   */
  @Valid 
  @Schema(name = "updatedAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedAt")
  public OffsetDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(OffsetDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(this.taskUUID, task.taskUUID) &&
        Objects.equals(this.projectUUID, task.projectUUID) &&
        Objects.equals(this.title, task.title) &&
        Objects.equals(this.blueprintUUID, task.blueprintUUID) &&
        Objects.equals(this.description, task.description) &&
        Objects.equals(this.day, task.day) &&
        Objects.equals(this.status, task.status) &&
        Objects.equals(this.dueDate, task.dueDate) &&
        Objects.equals(this.createdAt, task.createdAt) &&
        Objects.equals(this.updatedAt, task.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taskUUID, projectUUID, title, blueprintUUID, description, day, status, dueDate, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    sb.append("    taskUUID: ").append(toIndentedString(taskUUID)).append("\n");
    sb.append("    projectUUID: ").append(toIndentedString(projectUUID)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    blueprintUUID: ").append(toIndentedString(blueprintUUID)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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

