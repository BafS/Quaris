package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;




/**
 * Event
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-15T16:56:19.733+01:00")

public class Event   {
  private String name = null;

  private String identifier = null;

  private Object payload = null;

  private DateTime timestamp = null;

  public Event name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Event's name
   * @return name
  **/
  @ApiModelProperty(value = "Event's name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Event identifier(String identifier) {
    this.identifier = identifier;
    return this;
  }

   /**
   * user identifier
   * @return identifier
  **/
  @ApiModelProperty(value = "user identifier")
  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public Event payload(Object payload) {
    this.payload = payload;
    return this;
  }

   /**
   * Parameters to use in rules (optional)
   * @return payload
  **/
  @ApiModelProperty(value = "Parameters to use in rules (optional)")
  public Object getPayload() {
    return payload;
  }

  public void setPayload(Object payload) {
    this.payload = payload;
  }

  public Event timestamp(DateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Get timestamp
   * @return timestamp
  **/
  @ApiModelProperty(value = "")
  public DateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(DateTime timestamp) {
    this.timestamp = timestamp;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.name, event.name) &&
        Objects.equals(this.identifier, event.identifier) &&
        Objects.equals(this.payload, event.payload) &&
        Objects.equals(this.timestamp, event.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, identifier, payload, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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

