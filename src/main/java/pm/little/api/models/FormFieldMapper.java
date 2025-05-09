package pm.little.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import pm.little.api.models.ids.FormFieldMapperId;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Mapping a field within a form
 */
@Entity
@Schema(name = "FormFieldMapper", description = "Mapping a field within a form")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-27T23:47:32.256351+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class FormFieldMapper {
  @EmbeddedId
  private FormFieldMapperId id;

  @NotNull
  private Integer sortOrder;

  public FormFieldMapper() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FormFieldMapper(FormFieldMapperId id, Integer sortOrder) {
    this.id = id;
    this.sortOrder = sortOrder;
  }

  public FormFieldMapper id(FormFieldMapperId id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  @NotNull @Valid 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public FormFieldMapperId getId() {
    return id;
  }

  public void setId(FormFieldMapperId id) {
    this.id = id;
  }

  public FormFieldMapper sortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  /**
   * Order or position within a list
   * @return sortOrder
   */
  @NotNull 
  @Schema(name = "sortOrder", description = "Order or position within a list", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sortOrder")
  public Integer getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
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
    return Objects.equals(this.id, formFieldMapper.id) &&
        Objects.equals(this.sortOrder, formFieldMapper.sortOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sortOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormFieldMapper {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    sortOrder: ").append(toIndentedString(sortOrder)).append("\n");
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

