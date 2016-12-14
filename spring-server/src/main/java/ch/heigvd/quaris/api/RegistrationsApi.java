package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.dto.Registration;
import ch.heigvd.quaris.api.dto.RegistrationSummary;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-12-13T13:20:34.690Z")

@Api(value = "registrations", description = "the registrations API")
public interface RegistrationsApi {

    @ApiOperation(value = "", notes = "", response = RegistrationSummary.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List all registered applications", response = RegistrationSummary.class) })
    @RequestMapping(value = "/registrations",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<RegistrationSummary>> registrationsGet();


    @ApiOperation(value = "", notes = "", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Register a new application", response = Void.class) })
    @RequestMapping(value = "/registrations",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> registrationsPost(@ApiParam(value = "The info required to register an application", required = true) @RequestBody Registration body);

}
