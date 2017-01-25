package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import ch.heigvd.quaris.api.dto.BadgeDTO;
import ch.heigvd.quaris.api.dto.ScaleDTO;
import ch.heigvd.quaris.api.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * UserDetailsDTO
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T15:44:32.358+01:00")

public class UserDetailsDTO   {
  private UserDTO user = null;

  private List<BadgeDTO> badges = new ArrayList<BadgeDTO>();

  private List<ScaleDTO> scales = new ArrayList<ScaleDTO>();

  public UserDetailsDTO user(UserDTO user) {
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

  public UserDetailsDTO badges(List<BadgeDTO> badges) {
    this.badges = badges;
    return this;
  }

  public UserDetailsDTO addBadgesItem(BadgeDTO badgesItem) {
    this.badges.add(badgesItem);
    return this;
  }

   /**
   * Get badges
   * @return badges
  **/
  @ApiModelProperty(value = "")
  public List<BadgeDTO> getBadges() {
    return badges;
  }

  public void setBadges(List<BadgeDTO> badges) {
    this.badges = badges;
  }

  public UserDetailsDTO scales(List<ScaleDTO> scales) {
    this.scales = scales;
    return this;
  }

  public UserDetailsDTO addScalesItem(ScaleDTO scalesItem) {
    this.scales.add(scalesItem);
    return this;
  }

   /**
   * Get scales
   * @return scales
  **/
  @ApiModelProperty(value = "")
  public List<ScaleDTO> getScales() {
    return scales;
  }

  public void setScales(List<ScaleDTO> scales) {
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
    UserDetailsDTO userDetailsDTO = (UserDetailsDTO) o;
    return Objects.equals(this.user, userDetailsDTO.user) &&
        Objects.equals(this.badges, userDetailsDTO.badges) &&
        Objects.equals(this.scales, userDetailsDTO.scales);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, badges, scales);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDetailsDTO {\n");
    
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

