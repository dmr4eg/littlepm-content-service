package pm.little.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.lang.Nullable;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import pm.little.api.models.enums.InputTypeEnum;

/**
 * FormField
 */
@Entity
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-27T23:47:32.256351+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class Field {
  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID formFieldUuid;

  /**
   * Gets or Sets inputType
   */


  private InputTypeEnum inputType;

  private @Nullable Boolean required;

  private String title;

  private @Nullable String description;

  public Field() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Field(UUID formFieldUuid, InputTypeEnum inputType, String title) {
    this.formFieldUuid = formFieldUuid;
    this.inputType = inputType;
    this.title = title;
  }

  public Field formFieldUuid(UUID formFieldUuid) {
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

  public Field inputType(InputTypeEnum inputType) {
    this.inputType = inputType;
    return this;
  }

  /**
   * Get inputType
   * @return inputType
   */
  @NotNull 
  @Schema(name = "input_type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("input_type")
  public InputTypeEnum getInputType() {
    return inputType;
  }

  public void setInputType(InputTypeEnum inputType) {
    this.inputType = inputType;
  }

  public Field required(Boolean required) {
    this.required = required;
    return this;
  }

  /**
   * Get required
   * @return required
   */
  
  @Schema(name = "required", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("required")
  public Boolean getRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public Field title(String title) {
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

  public Field description(String description) {
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
    Field field = (Field) o;
    return Objects.equals(this.formFieldUuid, field.formFieldUuid) &&
        Objects.equals(this.inputType, field.inputType) &&
        Objects.equals(this.required, field.required) &&
        Objects.equals(this.title, field.title) &&
        Objects.equals(this.description, field.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(formFieldUuid, inputType, required, title, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormField {\n");
    sb.append("    formFieldUuid: ").append(toIndentedString(formFieldUuid)).append("\n");
    sb.append("    inputType: ").append(toIndentedString(inputType)).append("\n");
    sb.append("    required: ").append(toIndentedString(required)).append("\n");
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

