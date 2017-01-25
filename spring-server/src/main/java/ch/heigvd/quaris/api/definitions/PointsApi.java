package ch.heigvd.quaris.api.definitions;

import ch.heigvd.quaris.api.dto.ErrorDTO;
import ch.heigvd.quaris.api.dto.PointDTO;

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

@Api(value = "points", description = "the points API")
public interface PointsApi {

    @ApiOperation(value = "All Scales", notes = "The Scales endpoint returns information about all the points.", response = PointDTO.class, responseContainer = "List", authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Point", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Points information", response = PointDTO.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = PointDTO.class) })
    @RequestMapping(value = "/points",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PointDTO>> pointsGet();


    @ApiOperation(value = "All Scales", notes = "The Scales endpoint returns information about all the existing scales.", response = PointDTO.class, responseContainer = "List", authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Point", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "User's scales information", response = PointDTO.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = PointDTO.class) })
    @RequestMapping(value = "/points/{identifier}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PointDTO>> pointsIdentifierGet(
@ApiParam(value = "Identifier",required=true ) @PathVariable("identifier") String identifier


);

}
