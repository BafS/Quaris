package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.dto.Error;
import ch.heigvd.quaris.api.dto.Scale;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-14T23:22:01.292+01:00")

@Api(value = "scales", description = "the scales API")
public interface ScalesApi {

    @ApiOperation(value = "All Scales", notes = "The Scales endpoint returns information about all the existing scales.", response = Scale.class, responseContainer = "List", tags={ "Scale", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Scales' information", response = Scale.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Scale.class) })
    @RequestMapping(value = "/scales",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Scale>> scalesGet();


    @ApiOperation(value = "Create a new Scale", notes = "Create a new Scale.", response = Void.class, tags={ "Scale", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Scale was created", response = Void.class),
        @ApiResponse(code = 409, message = "Conflict, the Scale name already exists", response = Void.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Void.class) })
    @RequestMapping(value = "/scales",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> scalesPost(

@ApiParam(value = "Scale to add" ,required=true ) @RequestBody Scale scale

);

}
