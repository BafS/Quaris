package ch.heigvd.quaris.api.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;




/**
 * EventDTO
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T16:31:01.726+01:00")

public class EventDTO   {
  private String type = null;

  private String identifier = null;

  private Object payload = null;

  private DateTime createdAt = null;

  private String application = null;

  public EventDTO type(String type) {
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

  public EventDTO identifier(String identifier) {
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

  public EventDTO payload(Object payload) {
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

  public EventDTO createdAt(DateTime createdAt) {
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

  public EventDTO application(String application) {
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
    EventDTO eventDTO = (EventDTO) o;
    return Objects.equals(this.type, eventDTO.type) &&
        Objects.equals(this.identifier, eventDTO.identifier) &&
        Objects.equals(this.payload, eventDTO.payload) &&
        Objects.equals(this.createdAt, eventDTO.createdAt) &&
        Objects.equals(this.application, eventDTO.application);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, identifier, payload, createdAt, application);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventDTO {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
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

