package pm.little.api.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
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
import pm.little.api.models.enums.TypeEnum;


import java.util.*;

/**
 * Media
 */
@Entity
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-27T23:47:32.256351+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class Media {
  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID mediaUUID;

  @NotNull
  @Valid
  private TypeEnum type;

  @NotNull @Valid
  private String title;

  @NotNull @Valid
  private URI url;

  @Nullable
  private String description;

  public Media() {
    super();
  }


  public void setUrl(@NotNull @Valid URI url) {
    this.url = url;
  }

  /**
   * Constructor with only required parameters
   */
  public Media(UUID mediaUUID, TypeEnum type, String title) {
    this.mediaUUID = mediaUUID;
    this.type = type;
    this.title = title;
  }

  public Media mediaUUID(UUID mediaUUID) {
    this.mediaUUID = mediaUUID;
    return this;
  }

  /**
   * UUID for a Media resource
   * @return mediaUUID
   */
  @NotNull @Valid 
  @Schema(name = "mediaUUID", description = "UUID for a Media resource", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("mediaUUID")
  public UUID getMediaUUID() {
    return mediaUUID;
  }

  public void setMediaUUID(UUID mediaUUID) {
    this.mediaUUID = mediaUUID;
  }

  public Media type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @NotNull 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public Media title(String title) {
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

  public Media description(String description) {
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
    Media media = (Media) o;
    return Objects.equals(this.mediaUUID, media.mediaUUID) &&
        Objects.equals(this.type, media.type) &&
        Objects.equals(this.title, media.title) &&
        Objects.equals(this.description, media.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mediaUUID, type, title, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Media {\n");
    sb.append("    mediaUUID: ").append(toIndentedString(mediaUUID)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

  @Nullable
  public @Valid URI getUrl() {
    return url;
  }
}

