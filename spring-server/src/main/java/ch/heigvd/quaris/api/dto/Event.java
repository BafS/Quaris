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
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-24T18:40:38.222+01:00")

public class Event   {
  private String type = null;

  private String identifier = null;

  private Object payload = null;

  private DateTime timestamp = null;

  private String application = null;

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
   * User identifier
   * @return identifier
  **/
  @ApiModelProperty(value = "User identifier")
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

  public Event application(String application) {
    this.application = application;
    return this;
  }

   /**
   * Application name
   * @return application
  **/
  @ApiModelProperty(value = "Application name")
  public String getApplication() {
    return application;
  }

  public void setApplication(String application) {
    this.application = application;
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
    return Objects.equals(this.type, event.type) &&
        Objects.equals(this.identifier, event.identifier) &&
        Objects.equals(this.payload, event.payload) &&
        Objects.equals(this.timestamp, event.timestamp) &&
        Objects.equals(this.application, event.application);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, identifier, payload, timestamp, application);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    application: ").append(toIndentedString(application)).append("\n");
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

