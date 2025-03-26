package pm.little.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.Nullable;

import io.swagger.v3.oas.annotations.media.Schema;


/**
 * FormBlueprint
 */
@Entity
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-26T00:36:51.210059+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class FormBlueprint {
  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.UUID)
  private @Nullable UUID formBlueprintUuid;

  private @Nullable String title;

  private @Nullable String description;

  private @Nullable String callbackUrl;

  public FormBlueprint formBlueprintUuid(UUID formBlueprintUuid) {
    this.formBlueprintUuid = formBlueprintUuid;
    return this;
  }

  /**
   * Get formBlueprintUuid
   * @return formBlueprintUuid
   */
  @Valid
  @Schema(name = "form_blueprint_uuid", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("form_blueprint_uuid")
  public UUID getFormBlueprintUuid() {
    return formBlueprintUuid;
  }

  public void setFormBlueprintUuid(UUID formBlueprintUuid) {
    this.formBlueprintUuid = formBlueprintUuid;
  }

  public FormBlueprint title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  
  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public FormBlueprint description(String description) {
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

  public FormBlueprint callbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

  /**
   * Get callbackUrl
   * @return callbackUrl
   */
  
  @Schema(name = "callback_url", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("callback_url")
  public String getCallbackUrl() {
    return callbackUrl;
  }

  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormBlueprint formBlueprint = (FormBlueprint) o;
    return Objects.equals(this.formBlueprintUuid, formBlueprint.formBlueprintUuid) &&
        Objects.equals(this.title, formBlueprint.title) &&
        Objects.equals(this.description, formBlueprint.description) &&
        Objects.equals(this.callbackUrl, formBlueprint.callbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formBlueprintUuid, title, description, callbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormBlueprint {\n");
    sb.append("    formBlueprintUuid: ").append(toIndentedString(formBlueprintUuid)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
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

