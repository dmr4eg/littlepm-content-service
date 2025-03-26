package pm.little.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.lang.Nullable;

import io.swagger.v3.oas.annotations.media.Schema;


/**
 * FormFieldMapper
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-26T00:36:51.210059+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class FormFieldMapper {

  private @Nullable UUID formBlueprintUuid;

  private @Nullable UUID formField;

  private @Nullable Integer order;

  public FormFieldMapper formBlueprintUuid(UUID formBlueprintUuid) {
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

  public FormFieldMapper formField(UUID formField) {
    this.formField = formField;
    return this;
  }

  /**
   * Get formField
   * @return formField
   */
  @Valid 
  @Schema(name = "form_field", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("form_field")
  public UUID getFormField() {
    return formField;
  }

  public void setFormField(UUID formField) {
    this.formField = formField;
  }

  public FormFieldMapper order(Integer order) {
    this.order = order;
    return this;
  }

  /**
   * Get order
   * @return order
   */
  
  @Schema(name = "order", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("order")
  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormFieldMapper formFieldMapper = (FormFieldMapper) o;
    return Objects.equals(this.formBlueprintUuid, formFieldMapper.formBlueprintUuid) &&
        Objects.equals(this.formField, formFieldMapper.formField) &&
        Objects.equals(this.order, formFieldMapper.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formBlueprintUuid, formField, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormFieldMapper {\n");
    sb.append("    formBlueprintUuid: ").append(toIndentedString(formBlueprintUuid)).append("\n");
    sb.append("    formField: ").append(toIndentedString(formField)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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

