package pm.little.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;
import org.springframework.lang.Nullable;

import io.swagger.v3.oas.annotations.media.Schema;
import pm.little.api.models.enums.InputTypeEnum;


/**
 * FormsFormBlueprintUuidFieldsFieldUuidPutRequest
 */

@JsonTypeName("_forms__form_blueprint_uuid__fields__field_uuid__put_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-26T00:36:51.210059+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class FormsFormBlueprintUuidFieldsFieldUuidPutRequest {

  /**
   * Gets or Sets inputType
   */


  private @Nullable InputTypeEnum inputType;

  private @Nullable Boolean required;

  private @Nullable String title;

  private @Nullable String description;

  public FormsFormBlueprintUuidFieldsFieldUuidPutRequest inputType(InputTypeEnum inputType) {
    this.inputType = inputType;
    return this;
  }

  /**
   * Get inputType
   * @return inputType
   */
  
  @Schema(name = "input_type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("input_type")
  public InputTypeEnum getInputType() {
    return inputType;
  }

  public void setInputType(InputTypeEnum inputType) {
    this.inputType = inputType;
  }

  public FormsFormBlueprintUuidFieldsFieldUuidPutRequest required(Boolean required) {
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

  public FormsFormBlueprintUuidFieldsFieldUuidPutRequest title(String title) {
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

  public FormsFormBlueprintUuidFieldsFieldUuidPutRequest description(String description) {
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
    FormsFormBlueprintUuidFieldsFieldUuidPutRequest formsFormBlueprintUuidFieldsFieldUuidPutRequest = (FormsFormBlueprintUuidFieldsFieldUuidPutRequest) o;
    return Objects.equals(this.inputType, formsFormBlueprintUuidFieldsFieldUuidPutRequest.inputType) &&
        Objects.equals(this.required, formsFormBlueprintUuidFieldsFieldUuidPutRequest.required) &&
        Objects.equals(this.title, formsFormBlueprintUuidFieldsFieldUuidPutRequest.title) &&
        Objects.equals(this.description, formsFormBlueprintUuidFieldsFieldUuidPutRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inputType, required, title, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormsFormBlueprintUuidFieldsFieldUuidPutRequest {\n");
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

