package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.LocalDate;




/**
 * UserDTO
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T15:44:32.358+01:00")

public class UserDTO   {
  private String userId = null;

  private Integer numberOfEvents = null;

  private LocalDate creationDate = null;

  public UserDTO userId(String userId) {
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

  public UserDTO numberOfEvents(Integer numberOfEvents) {
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

  public UserDTO creationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
    return this;
  }

   /**
   * Get creationDate
   * @return creationDate
  **/
  @ApiModelProperty(value = "")
  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDTO userDTO = (UserDTO) o;
    return Objects.equals(this.userId, userDTO.userId) &&
        Objects.equals(this.numberOfEvents, userDTO.numberOfEvents) &&
        Objects.equals(this.creationDate, userDTO.creationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, numberOfEvents, creationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDTO {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    numberOfEvents: ").append(toIndentedString(numberOfEvents)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
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

