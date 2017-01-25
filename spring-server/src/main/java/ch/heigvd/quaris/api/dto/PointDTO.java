package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import ch.heigvd.quaris.api.dto.ScaleDTO;
import ch.heigvd.quaris.api.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * PointDTO
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T15:44:32.358+01:00")

public class PointDTO   {
  private Integer point = null;

  private UserDTO user = null;

  private ScaleDTO scale = null;

  public PointDTO point(Integer point) {
    this.point = point;
    return this;
  }

   /**
   * Number of points
   * @return point
  **/
  @ApiModelProperty(value = "Number of points")
  public Integer getPoint() {
    return point;
  }

  public void setPoint(Integer point) {
    this.point = point;
  }

  public PointDTO user(UserDTO user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")
  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }

  public PointDTO scale(ScaleDTO scale) {
    this.scale = scale;
    return this;
  }

   /**
   * Get scale
   * @return scale
  **/
  @ApiModelProperty(value = "")
  public ScaleDTO getScale() {
    return scale;
  }

  public void setScale(ScaleDTO scale) {
    this.scale = scale;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PointDTO pointDTO = (PointDTO) o;
    return Objects.equals(this.point, pointDTO.point) &&
        Objects.equals(this.user, pointDTO.user) &&
        Objects.equals(this.scale, pointDTO.scale);
  }

  @Override
  public int hashCode() {
    return Objects.hash(point, user, scale);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PointDTO {\n");
    
    sb.append("    point: ").append(toIndentedString(point)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    scale: ").append(toIndentedString(scale)).append("\n");
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

