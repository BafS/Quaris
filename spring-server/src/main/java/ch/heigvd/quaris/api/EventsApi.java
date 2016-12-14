package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.dto.Event;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-13T13:20:34.690Z")

@Api(value = "events", description = "the events API")
public interface EventsApi {

    @ApiOperation(value = "Create a new event", notes = "When an event happens on the client side, an Event object is posted to the API.", response = Event.class, tags={ "Event", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Event was accepted", response = Event.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Event.class) })
    @RequestMapping(value = "/events",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Event> reportEvent(@ApiParam(value = "token that identifies the application sending the request", required = true) @RequestHeader(value = "X-Gamification-Token", required = true) String xGamificationToken,
                                      @ApiParam(value = "Event to add", required = true) @RequestBody Event event);

}
