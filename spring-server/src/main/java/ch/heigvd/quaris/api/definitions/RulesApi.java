package ch.heigvd.quaris.api.definitions;

import ch.heigvd.quaris.api.dto.Rule;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-30T03:48:03.027+01:00")

@Api(value = "rules", description = "the rules API")
public interface RulesApi {

    @ApiOperation(value = "All Rules", notes = "The Rules endpoint returns information about all the existing rules.", response = Rule.class, responseContainer = "List", authorizations = {
        @Authorization(value = "Bearer")
    }, tags={ "Rule", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Rules' information", response = Rule.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = Rule.class) })
    @RequestMapping(value = "/rules",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> rulesGet();


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

@ApiParam(value = "Rule to add" ,required=true ) @RequestBody Rule rule

);

}
