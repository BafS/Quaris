package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * ScaleDTO
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T15:44:32.358+01:00")

public class ScaleDTO   {
  private String name = null;

  private String description = null;

  public ScaleDTO name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Scale's name
   * @return name
  **/
  @ApiModelProperty(value = "Scale's name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ScaleDTO description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Scale's description
   * @return description
  **/
  @ApiModelProperty(value = "Scale's description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScaleDTO scaleDTO = (ScaleDTO) o;
    return Objects.equals(this.name, scaleDTO.name) &&
        Objects.equals(this.description, scaleDTO.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScaleDTO {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

