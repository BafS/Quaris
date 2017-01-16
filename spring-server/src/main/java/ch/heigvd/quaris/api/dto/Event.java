package ch.heigvd.quaris.api.dto;

import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

import java.util.Objects;


/**
 * Event
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-16T15:31:26.895+01:00")

public class Event {
  private String type = null;

  private String identifier = null;

  private Object payload = null;

  private DateTime timestamp = null;

  public Event type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Event's type
   * @return type
  **/
  @ApiModelProperty(value = "Event's type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.type, event.type) &&
        Objects.equals(this.identifier, event.identifier) &&
        Objects.equals(this.payload, event.payload) &&
        Objects.equals(this.timestamp, event.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, identifier, payload, timestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");

    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

