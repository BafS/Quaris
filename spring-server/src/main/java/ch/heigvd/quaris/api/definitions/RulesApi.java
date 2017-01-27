package ch.heigvd.quaris.api.definitions;

import ch.heigvd.quaris.api.dto.RuleDTO;
import ch.heigvd.quaris.api.dto.ErrorDTO;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-27T03:33:37.131+01:00")

@Api(value = "rules", description = "the rules API")
public interface RulesApi {

    @ApiOperation(value = "All Rules", notes = "The Rules endpoint returns information about all the existing rules.", response = RuleDTO.class, responseContainer = "List", authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Rule", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Rules' information", response = RuleDTO.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = RuleDTO.class) })
    @RequestMapping(value = "/rules",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<RuleDTO>> rulesGet();


    @ApiOperation(value = "Modify existing Rule", notes = "Modify an existing Rule", response = Void.class, authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Rule", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Rule modified successfully", response = Void.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Void.class) })
    @RequestMapping(value = "/rules/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> rulesIdPut(
@ApiParam(value = "Rule id",required=true ) @PathVariable("id") String id


,

@ApiParam(value = "new Rule data" ,required=true ) @RequestBody RuleDTO data

);


    @ApiOperation(value = "Create a new Rule", notes = "Create a new Rule.", response = Void.class, authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Rule", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Rule was created", response = Void.class),
        @ApiResponse(code = 409, message = "Conflict, the rule name already exists", response = Void.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Void.class) })
    @RequestMapping(value = "/rules",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> rulesPost(

@ApiParam(value = "Rule to add" ,required=true ) @RequestBody RuleDTO rule

);

}
