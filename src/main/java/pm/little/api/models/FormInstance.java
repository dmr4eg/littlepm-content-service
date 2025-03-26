package pm.little.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.lang.Nullable;

import io.swagger.v3.oas.annotations.media.Schema;


/**
 * FormInstance
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-26T00:36:51.210059+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class FormInstance {

  private @Nullable UUID formBlueprintUuid;

  private @Nullable UUID userUuid;

  private @Nullable Boolean status;

  public FormInstance formBlueprintUuid(UUID formBlueprintUuid) {
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

  public FormInstance userUuid(UUID userUuid) {
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

  public FormInstance status(Boolean status) {
    this.status = status;
    return this;
  }

  /**
   * True if form is completed, false otherwise
   * @return status
   */
  
  @Schema(name = "status", description = "True if form is completed, false otherwise", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    FormInstance formInstance = (FormInstance) o;
    return Objects.equals(this.formBlueprintUuid, formInstance.formBlueprintUuid) &&
        Objects.equals(this.userUuid, formInstance.userUuid) &&
        Objects.equals(this.status, formInstance.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formBlueprintUuid, userUuid, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormInstance {\n");
    sb.append("    formBlueprintUuid: ").append(toIndentedString(formBlueprintUuid)).append("\n");
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

