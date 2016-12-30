package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * User
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-30T03:48:03.027+01:00")

public class User   {
  private String userId = null;

  private Integer numberOfEvents = null;

  public User userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public User numberOfEvents(Integer numberOfEvents) {
    this.numberOfEvents = numberOfEvents;
    return this;
  }

   /**
   * Get numberOfEvents
   * @return numberOfEvents
  **/
  @ApiModelProperty(value = "")
  public Integer getNumberOfEvents() {
    return numberOfEvents;
  }

  public void setNumberOfEvents(Integer numberOfEvents) {
    this.numberOfEvents = numberOfEvents;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.userId, user.userId) &&
        Objects.equals(this.numberOfEvents, user.numberOfEvents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, numberOfEvents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    numberOfEvents: ").append(toIndentedString(numberOfEvents)).append("\n");
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

