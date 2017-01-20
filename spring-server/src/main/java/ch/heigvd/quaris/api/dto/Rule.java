package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Rule
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-20T20:41:52.586+01:00")

public class Rule   {
  private String name = null;

  private String criteria = null;

  private String action = null;

  private Boolean enabled = null;

  public Rule name(String name) {
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

  public Rule criteria(String criteria) {
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

  public Rule action(String action) {
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

  public Rule enabled(Boolean enabled) {
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
    Rule rule = (Rule) o;
    return Objects.equals(this.name, rule.name) &&
        Objects.equals(this.criteria, rule.criteria) &&
        Objects.equals(this.action, rule.action) &&
        Objects.equals(this.enabled, rule.enabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, criteria, action, enabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rule {\n");
    
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

