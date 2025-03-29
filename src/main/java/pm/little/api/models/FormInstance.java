package pm.little.api.models;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import pm.little.api.models.ids.FormInstanceId;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


/**
 * Specific instance of a form for a user
 */
@Entity
@Schema(name = "FormInstance", description = "Specific instance of a form for a user")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-03-27T23:47:32.256351+01:00[Europe/Prague]", comments = "Generator version: 7.11.0")
public class FormInstance {
  @EmbeddedId
  private FormInstanceId id;

  @NotNull
  private Boolean status;

  public FormInstance() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FormInstance(FormInstanceId id, Boolean status) {
    this.id = id;
    this.status = status;
  }

  public FormInstance id(FormInstanceId id) {
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
  public FormInstanceId getId() {
    return id;
  }

  public void setId(FormInstanceId id) {
    this.id = id;
  }

  public FormInstance status(Boolean status) {
    this.status = status;
    return this;
  }

  /**
   * True if form is completed, false otherwise
   * @return status
   */
  @NotNull 
  @Schema(name = "status", description = "True if form is completed, false otherwise", requiredMode = Schema.RequiredMode.REQUIRED)
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
    return Objects.equals(this.id, formInstance.id) &&
        Objects.equals(this.status, formInstance.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormInstance {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

