package ch.heigvd.quaris.api.definitions;

import ch.heigvd.quaris.api.dto.Error;
import ch.heigvd.quaris.api.dto.Point;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-24T03:19:55.143+01:00")

@Api(value = "points", description = "the points API")
public interface PointsApi {

    @ApiOperation(value = "All Scales", notes = "The Scales endpoint returns information about all the points.", response = Point.class, responseContainer = "List", authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Point", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Points information", response = Point.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Point.class) })
    @RequestMapping(value = "/points",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Point>> pointsGet();


    @ApiOperation(value = "All Scales", notes = "The Scales endpoint returns information about all the existing scales.", response = Point.class, responseContainer = "List", authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Point", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "User's scales information", response = Point.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Point.class) })
    @RequestMapping(value = "/points/{identifier}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Point>> pointsIdentifierGet(
@ApiParam(value = "Identifier",required=true ) @PathVariable("identifier") String identifier


);

}
