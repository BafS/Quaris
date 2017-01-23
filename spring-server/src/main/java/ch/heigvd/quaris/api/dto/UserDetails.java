package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import ch.heigvd.quaris.api.dto.Badge;
import ch.heigvd.quaris.api.dto.Scale;
import ch.heigvd.quaris.api.dto.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * UserDetails
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-23T14:46:09.926+01:00")

public class UserDetails   {
  private User user = null;

  private List<Badge> badges = new ArrayList<Badge>();

  private List<Scale> scales = new ArrayList<Scale>();

  public UserDetails user(User user) {
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

  public UserDetails badges(List<Badge> badges) {
    this.badges = badges;
    return this;
  }

  public UserDetails addBadgesItem(Badge badgesItem) {
    this.badges.add(badgesItem);
    return this;
  }

   /**
   * Get badges
   * @return badges
  **/
  @ApiModelProperty(value = "")
  public List<Badge> getBadges() {
    return badges;
  }

  public void setBadges(List<Badge> badges) {
    this.badges = badges;
  }

  public UserDetails scales(List<Scale> scales) {
    this.scales = scales;
    return this;
  }

  public UserDetails addScalesItem(Scale scalesItem) {
    this.scales.add(scalesItem);
    return this;
  }

   /**
   * Get scales
   * @return scales
  **/
  @ApiModelProperty(value = "")
  public List<Scale> getScales() {
    return scales;
  }

  public void setScales(List<Scale> scales) {
    this.scales = scales;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserDetails userDetails = (UserDetails) o;
    return Objects.equals(this.user, userDetails.user) &&
        Objects.equals(this.badges, userDetails.badges) &&
        Objects.equals(this.scales, userDetails.scales);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, badges, scales);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDetails {\n");
    
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    badges: ").append(toIndentedString(badges)).append("\n");
    sb.append("    scales: ").append(toIndentedString(scales)).append("\n");
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

