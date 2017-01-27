package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BadgeDTO
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T15:44:32.358+01:00")

public class BadgeDTO   {
  private String name = null;

  private String description = null;

  private byte[] icon = null;

  public BadgeDTO name(String name) {
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

  public BadgeDTO description(String description) {
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

  public BadgeDTO icon(byte[] icon) {
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
    BadgeDTO badgeDTO = (BadgeDTO) o;
    return Objects.equals(this.name, badgeDTO.name) &&
        Objects.equals(this.description, badgeDTO.description) &&
        Objects.equals(this.icon, badgeDTO.icon);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, icon);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadgeDTO {\n");
    
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

