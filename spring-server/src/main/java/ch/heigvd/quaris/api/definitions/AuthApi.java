package ch.heigvd.quaris.api.definitions;

import ch.heigvd.quaris.api.dto.Token;
import ch.heigvd.quaris.api.dto.Credentials;

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

@Api(value = "auth", description = "the auth API")
public interface AuthApi {

    @ApiOperation(value = "", notes = "", response = Token.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Authentication sucessful", response = Token.class),
        @ApiResponse(code = 401, message = "Authentication failed", response = Token.class) })
    @RequestMapping(value = "/auth",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Token> authenticateApplicationAndGetToken(

@ApiParam(value = "The info required to authenticate an application" ,required=true ) @RequestBody Credentials body

);

}
