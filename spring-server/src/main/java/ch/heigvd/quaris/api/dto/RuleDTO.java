package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * RuleDTO
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-27T10:57:14.535+01:00")

public class RuleDTO   {
  private Integer id = null;

  private String name = null;

  private String criteria = null;

  private String action = null;

  private Boolean enabled = null;

  public RuleDTO id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Rule's ID.
   * @return id
  **/
  @ApiModelProperty(value = "Rule's ID.")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RuleDTO name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Rule's name. Unique identifier.
   * @return name
  **/
  @ApiModelProperty(value = "Rule's name. Unique identifier.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RuleDTO criteria(String criteria) {
    this.criteria = criteria;
    return this;
  }

   /**
   * Logical condition needed to apply the rule (javascript).
   * @return criteria
  **/
  @ApiModelProperty(value = "Logical condition needed to apply the rule (javascript).")
  public String getCriteria() {
    return criteria;
  }

  public void setCriteria(String criteria) {
    this.criteria = criteria;
  }

  public RuleDTO action(String action) {
    this.action = action;
    return this;
  }

   /**
   * Action to take if condition is met (javascript).
   * @return action
  **/
  @ApiModelProperty(value = "Action to take if condition is met (javascript).")
  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public RuleDTO enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

   /**
   * If the Rule is enabled or not
   * @return enabled
  **/
  @ApiModelProperty(value = "If the Rule is enabled or not")
  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RuleDTO ruleDTO = (RuleDTO) o;
    return Objects.equals(this.id, ruleDTO.id) &&
        Objects.equals(this.name, ruleDTO.name) &&
        Objects.equals(this.criteria, ruleDTO.criteria) &&
        Objects.equals(this.action, ruleDTO.action) &&
        Objects.equals(this.enabled, ruleDTO.enabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, criteria, action, enabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RuleDTO {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    criteria: ").append(toIndentedString(criteria)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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

