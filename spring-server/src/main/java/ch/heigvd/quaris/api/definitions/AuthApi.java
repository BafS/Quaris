package ch.heigvd.quaris.api.definitions;

import ch.heigvd.quaris.api.dto.CredentialsDTO;
import ch.heigvd.quaris.api.dto.TokenDTO;

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

@Api(value = "auth", description = "the auth API")
public interface AuthApi {

    @ApiOperation(value = "", notes = "", response = TokenDTO.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "Authentication sucessful", response = TokenDTO.class),
        @ApiResponse(code = 401, message = "Authentication failed", response = TokenDTO.class) })
    @RequestMapping(value = "/auth",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<TokenDTO> authenticateApplicationAndGetToken(

@ApiParam(value = "The info required to authenticate an application" ,required=true ) @RequestBody CredentialsDTO body

);

}
