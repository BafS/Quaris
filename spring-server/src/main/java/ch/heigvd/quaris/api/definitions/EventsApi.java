package ch.heigvd.quaris.api.definitions;

import ch.heigvd.quaris.api.dto.ErrorDTO;
import ch.heigvd.quaris.api.dto.EventDTO;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-25T15:44:32.358+01:00")

@Api(value = "events", description = "the events API")
public interface EventsApi {

    @ApiOperation(value = "Create a new event", notes = "When an event happens on the client side, an Event object is posted to the API.", response = EventDTO.class, authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Event", })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "Event was accepted", response = EventDTO.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = EventDTO.class) })
    @RequestMapping(value = "/events",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<EventDTO> reportEvent(

@ApiParam(value = "Event to add" ,required=true ) @RequestBody EventDTO event

);

}
