package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.dto.Event;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.repositories.EndUserRepository;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.services.EventProcessor;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Olivier Liechti
 */
@RestController
public class EventsEndpoint implements EventsApi {

    @Autowired
    private final ApplicationRepository applicationsRepository = null;

    @Autowired
    private final EventProcessor eventProcessor = null;

//    public EventsEndpoint(ApplicationRepository applicationsRepository, EndUserRepository endUsersRepository, EventProcessor eventProcessor) {
//        this.applicationsRepository = applicationsRepository;
//        this.eventProcessor = eventProcessor;
//    }

    @Override
    public ResponseEntity reportEvent(@ApiParam(value = "Event to add", required = true) @RequestBody Event event) {
//        public ResponseEntity reportEvent(@RequestHeader(value="X-Gamification-Token") String xGamificationToken, @RequestBody Event event) {
//            String targetApplicationName = xGamificationToken;
        // -> Still pass X-Gamification-Token for public paths only ?

        String targetApplicationName = "TODO";
        String targetEndUserId = event.getIdentifier();
        Application targetApplication = applicationsRepository.findByName(targetApplicationName);
        if (targetApplication == null || targetEndUserId == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        eventProcessor.processEvent(targetApplication, event);
        return ResponseEntity.accepted().build();
    }
}
