package pm.little.api.models.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import pm.little.api.models.FormBlueprint;
import pm.little.api.models.FormInstance;

import io.swagger.v3.oas.annotations.media.Schema;



/**
 * FormDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-27T23:47:32.256351+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class FormDTO {

  private FormBlueprint blueprint;

  private FormInstance instance;

  public FormDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FormDTO(FormBlueprint blueprint, FormInstance instance) {
    this.blueprint = blueprint;
    this.instance = instance;
  }

  public FormDTO blueprint(FormBlueprint blueprint) {
    this.blueprint = blueprint;
    return this;
  }

  /**
   * Get blueprint
   * @return blueprint
   */
  @NotNull
  @Valid
  @Schema(name = "blueprint", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("blueprint")
  public FormBlueprint getBlueprint() {
    return blueprint;
  }

  public void setBlueprint(FormBlueprint blueprint) {
    this.blueprint = blueprint;
  }

  public FormDTO instance(FormInstance instance) {
    this.instance = instance;
    return this;
  }

  /**
   * Get instance
   * @return instance
   */
  @NotNull @Valid 
  @Schema(name = "instance", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("instance")
  public FormInstance getInstance() {
    return instance;
  }

  public void setInstance(FormInstance instance) {
    this.instance = instance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FormDTO formDTO = (FormDTO) o;
    return Objects.equals(this.blueprint, formDTO.blueprint) &&
        Objects.equals(this.instance, formDTO.instance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(blueprint, instance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormDTO {\n");
    sb.append("    blueprint: ").append(toIndentedString(blueprint)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
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

