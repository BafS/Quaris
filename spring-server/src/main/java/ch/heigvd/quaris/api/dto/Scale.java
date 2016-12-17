package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Scale
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-14T23:22:01.292+01:00")

public class Scale   {
  private String name = null;

  private String description = null;

  public Scale name(String name) {
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

  public Scale description(String description) {
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
    Scale scale = (Scale) o;
    return Objects.equals(this.name, scale.name) &&
        Objects.equals(this.description, scale.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Scale {\n");
    
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

