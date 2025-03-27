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
 * Composite ID for FormInstance
 */
@Embeddable
@Schema(name = "FormInstanceId", description = "Composite ID for FormInstance")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-27T23:47:32.256351+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class FormInstanceId {

  private UUID formBlueprintUuid;

  private UUID userUuid;

  public FormInstanceId() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FormInstanceId(UUID formBlueprintUuid, UUID userUuid) {
    this.formBlueprintUuid = formBlueprintUuid;
    this.userUuid = userUuid;
  }

  public FormInstanceId formBlueprintUuid(UUID formBlueprintUuid) {
    this.formBlueprintUuid = formBlueprintUuid;
    return this;
  }

  /**
   * UUID for a Form Blueprint
   * @return formBlueprintUuid
   */
  @NotNull @Valid 
  @Schema(name = "form_blueprint_uuid", description = "UUID for a Form Blueprint", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("form_blueprint_uuid")
  public UUID getFormBlueprintUuid() {
    return formBlueprintUuid;
  }

  public void setFormBlueprintUuid(UUID formBlueprintUuid) {
    this.formBlueprintUuid = formBlueprintUuid;
  }

  public FormInstanceId userUuid(UUID userUuid) {
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
    FormInstanceId formInstanceId = (FormInstanceId) o;
    return Objects.equals(this.formBlueprintUuid, formInstanceId.formBlueprintUuid) &&
        Objects.equals(this.userUuid, formInstanceId.userUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formBlueprintUuid, userUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormInstanceId {\n");
    sb.append("    formBlueprintUuid: ").append(toIndentedString(formBlueprintUuid)).append("\n");
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

