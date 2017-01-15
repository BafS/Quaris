package ch.heigvd.quaris.services;

import ch.heigvd.quaris.api.dto.Event;
import ch.heigvd.quaris.repositories.EndUserRepository;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.models.EndUser;
import ch.heigvd.quaris.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventProcessor {

  @Autowired
  private final EndUserRepository endUsersRepository = null;

  @Autowired
  private final EventRepository eventRepository = null;

    @Async
    @Transactional
    public void processEvent(Application application, Event event) {
        EndUser targetEndUser = endUsersRepository.findByApplicationNameAndIdInApplication(application.getName(), event.getIdentifier());
        if (targetEndUser == null) {
            // TODO org.modelmapper ?

            targetEndUser = new EndUser();
            targetEndUser.setApplication(application);
            targetEndUser.setIdInGamifiedApplication(event.getIdentifier());
            targetEndUser.setNumberOfEvents(1);
            endUsersRepository.save(targetEndUser);

            ch.heigvd.quaris.models.Event eventModel = new ch.heigvd.quaris.models.Event();
            eventModel.setApp(application);
            eventModel.setPayload(""); // event.getPayload()); // TODO
            eventModel.setUser(targetEndUser);

            eventRepository.save(eventModel);

        } else {
            targetEndUser.setNumberOfEvents(targetEndUser.getNumberOfEvents() + 1);
        }
    }
}
