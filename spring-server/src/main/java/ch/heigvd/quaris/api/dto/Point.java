package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import ch.heigvd.quaris.api.dto.Scale;
import ch.heigvd.quaris.api.dto.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Point
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-24T03:19:55.143+01:00")

public class Point   {
  private Integer point = null;

  private User user = null;

  private Scale scale = null;

  public Point point(Integer point) {
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

  public Point user(User user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Point scale(Scale scale) {
    this.scale = scale;
    return this;
  }

   /**
   * Get scale
   * @return scale
  **/
  @ApiModelProperty(value = "")
  public Scale getScale() {
    return scale;
  }

  public void setScale(Scale scale) {
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
    Point point = (Point) o;
    return Objects.equals(this.point, point.point) &&
        Objects.equals(this.user, point.user) &&
        Objects.equals(this.scale, point.scale);
  }

  @Override
  public int hashCode() {
    return Objects.hash(point, user, scale);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Point {\n");
    
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

