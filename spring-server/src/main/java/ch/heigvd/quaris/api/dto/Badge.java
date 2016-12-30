package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Badge
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-30T03:48:03.027+01:00")

public class Badge   {
  private String name = null;

  private String description = null;

  private byte[] icon = null;

  public Badge name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Unique identifier representing the badge name.
   * @return name
  **/
  @ApiModelProperty(value = "Unique identifier representing the badge name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Badge description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Badge description
   * @return description
  **/
  @ApiModelProperty(value = "Badge description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Badge icon(byte[] icon) {
    this.icon = icon;
    return this;
  }

   /**
   * Image associated to the badge
   * @return icon
  **/
  @ApiModelProperty(value = "Image associated to the badge")
  public byte[] getIcon() {
    return icon;
  }

  public void setIcon(byte[] icon) {
    this.icon = icon;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Badge badge = (Badge) o;
    return Objects.equals(this.name, badge.name) &&
        Objects.equals(this.description, badge.description) &&
        Objects.equals(this.icon, badge.icon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, icon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Badge {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    icon: ").append(toIndentedString(icon)).append("\n");
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

