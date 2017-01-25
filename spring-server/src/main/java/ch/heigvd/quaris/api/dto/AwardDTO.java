package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import ch.heigvd.quaris.api.dto.BadgeDTO;
import ch.heigvd.quaris.api.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;




/**
 * AwardDTO
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T16:31:01.726+01:00")

public class AwardDTO   {
  private String application = null;

  private UserDTO user = null;

  private BadgeDTO badge = null;

  private DateTime createdAt = null;

  public AwardDTO application(String application) {
    this.application = application;
    return this;
  }

   /**
   * Award from the given application
   * @return application
  **/
  @ApiModelProperty(value = "Award from the given application")
  public String getApplication() {
    return application;
  }

  public void setApplication(String application) {
    this.application = application;
  }

  public AwardDTO user(UserDTO user) {
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

  public AwardDTO badge(BadgeDTO badge) {
    this.badge = badge;
    return this;
  }

   /**
   * Get badge
   * @return badge
  **/
  @ApiModelProperty(value = "")
  public BadgeDTO getBadge() {
    return badge;
  }

  public void setBadge(BadgeDTO badge) {
    this.badge = badge;
  }

  public AwardDTO createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(value = "")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AwardDTO awardDTO = (AwardDTO) o;
    return Objects.equals(this.application, awardDTO.application) &&
        Objects.equals(this.user, awardDTO.user) &&
        Objects.equals(this.badge, awardDTO.badge) &&
        Objects.equals(this.createdAt, awardDTO.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(application, user, badge, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AwardDTO {\n");
    
    sb.append("    application: ").append(toIndentedString(application)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    badge: ").append(toIndentedString(badge)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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

