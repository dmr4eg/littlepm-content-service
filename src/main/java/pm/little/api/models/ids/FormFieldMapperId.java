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
 * Composite ID for FormFieldMapper
 */
@Embeddable
@Schema(name = "FormFieldMapperId", description = "Composite ID for FormFieldMapper")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-27T23:47:32.256351+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class FormFieldMapperId {

  private UUID formBlueprintUuid;

  private UUID formFieldUuid;

  public FormFieldMapperId() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FormFieldMapperId(UUID formBlueprintUuid, UUID formFieldUuid) {
    this.formBlueprintUuid = formBlueprintUuid;
    this.formFieldUuid = formFieldUuid;
  }

  public FormFieldMapperId formBlueprintUuid(UUID formBlueprintUuid) {
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

  public FormFieldMapperId formFieldUuid(UUID formFieldUuid) {
    this.formFieldUuid = formFieldUuid;
    return this;
  }

  /**
   * UUID for a Form Field
   * @return formFieldUuid
   */
  @NotNull @Valid 
  @Schema(name = "form_field_uuid", description = "UUID for a Form Field", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("form_field_uuid")
  public UUID getFormFieldUuid() {
    return formFieldUuid;
  }

  public void setFormFieldUuid(UUID formFieldUuid) {
    this.formFieldUuid = formFieldUuid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormFieldMapperId formFieldMapperId = (FormFieldMapperId) o;
    return Objects.equals(this.formBlueprintUuid, formFieldMapperId.formBlueprintUuid) &&
        Objects.equals(this.formFieldUuid, formFieldMapperId.formFieldUuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formBlueprintUuid, formFieldUuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormFieldMapperId {\n");
    sb.append("    formBlueprintUuid: ").append(toIndentedString(formBlueprintUuid)).append("\n");
    sb.append("    formFieldUuid: ").append(toIndentedString(formFieldUuid)).append("\n");
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

