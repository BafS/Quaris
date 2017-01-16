package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.EventsApi;
import ch.heigvd.quaris.api.dto.Event;
import ch.heigvd.quaris.models.EndUser;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.repositories.EndUserRepository;
import ch.heigvd.quaris.services.EventProcessor;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fabien Salathe & Henrik Akesson
 */
@RestController
public class EventsEndpoint implements EventsApi {

    private final ApplicationRepository applicationsRepository;

    private final EndUserRepository endUsersRepository;

    private final EventProcessor eventProcessor;

    public EventsEndpoint(ApplicationRepository applicationsRepository, EndUserRepository endUsersRepository, EventProcessor eventProcessor) {
        this.applicationsRepository = applicationsRepository;
        this.endUsersRepository = endUsersRepository;
        this.eventProcessor = eventProcessor;
    }

    @Override
    public ResponseEntity reportEvent(@ApiParam(value = "Event to add", required = true) @RequestBody Event event) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String targetApplicationName = "";
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            targetApplicationName = authentication.getName();
        }

        Application targetApplication = applicationsRepository.findByName(targetApplicationName);
        String targetEndUserId = event.getIdentifier();

        if (targetApplication == null || targetEndUserId == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        EndUser targetEndUser = endUsersRepository.findByApplicationNameAndIdInApplication(targetApplication.getName(), targetEndUserId);

        ch.heigvd.quaris.models.Event eventModel = new ch.heigvd.quaris.models.Event();
        eventModel.setApp(targetApplication);
        // eventModel.setPayload(""); // event.getPayload()); // TODO ?

        eventModel.setUser(targetEndUser); // TODO remove ?
        eventModel.setIdentifier(targetEndUserId);

        eventModel.setType(event.getType());

        eventProcessor.processEvent(targetApplication, eventModel);

        return ResponseEntity.ok().build();
    }
}
