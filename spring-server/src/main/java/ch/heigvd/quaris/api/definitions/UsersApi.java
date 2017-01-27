package ch.heigvd.quaris.api.definitions;

import ch.heigvd.quaris.api.dto.UserDetailsDTO;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-01-27T02:35:58.352+01:00")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "", notes = "Retrieve all users", response = UserDetailsDTO.class, responseContainer = "List", authorizations = {
        @Authorization(value = "Bearer")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Returns the specified user details", response = UserDetailsDTO.class),
        @ApiResponse(code = 404, message = "No users found", response = UserDetailsDTO.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<UserDetailsDTO>> findAllUser();


    @ApiOperation(value = "", notes = "Retrieve one user by identifier", response = UserDetailsDTO.class, authorizations = {
        @Authorization(value = "Bearer")
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Returns the specified user details", response = UserDetailsDTO.class),
        @ApiResponse(code = 404, message = "User not found", response = UserDetailsDTO.class) })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserDetailsDTO> findUserById(
@ApiParam(value = "id of the user to fetch",required=true ) @PathVariable("id") String id


);

}
