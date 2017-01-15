package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.dto.Error;
import ch.heigvd.quaris.api.dto.Badge;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-15T16:56:19.733+01:00")

@Api(value = "badges", description = "the badges API")
public interface BadgesApi {

    @ApiOperation(value = "Badge Information", notes = "The Badge Information endpoint returns information about the given badge. ", response = Badge.class, authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Badge", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Badge object", response = Badge.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Badge.class) })
    @RequestMapping(value = "/badges/{badgename}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Badge> badgesBadgenameGet(
@ApiParam(value = "A specific Badge's name",required=true ) @PathVariable("badgename") String badgename


);


    @ApiOperation(value = "All Badges", notes = "The Badges endpoint returns information about all the badges existing.", response = Badge.class, responseContainer = "List", authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Badge", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Badges' information", response = Badge.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Badge.class) })
    @RequestMapping(value = "/badges",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Badge>> badgesGet();


    @ApiOperation(value = "Create a new Badge", notes = "Create a new Badge.", response = Void.class, authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Badge", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Badge was created", response = Void.class),
        @ApiResponse(code = 409, message = "Conflict, the badge name already exists", response = Void.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Void.class) })
    @RequestMapping(value = "/badges",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> badgesPost(

@ApiParam(value = "Badge to add" ,required=true ) @RequestBody Badge badge

);

}
