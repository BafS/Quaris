package ch.heigvd.quaris.services;

import ch.heigvd.quaris.models.Event;
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

        EndUser targetEndUser = event.getUser();
        System.out.println("[i] targetEndUser:: " + targetEndUser.getIdInGamifiedApplication());
        // endUsersRepository.findByApplicationNameAndIdInApplication(application.getName(), event.getUser().getIdInGamifiedApplication());

        if (targetEndUser == null) {
            // TODO org.modelmapper ?

            targetEndUser = new EndUser();
            targetEndUser.setApplication(application);
            targetEndUser.setIdInGamifiedApplication(event.getUser().getIdInGamifiedApplication());
            targetEndUser.setNumberOfEvents(1);
            endUsersRepository.save(targetEndUser);
        } else {
            event.setUser(targetEndUser);
            eventRepository.save(event);

            targetEndUser.setNumberOfEvents(targetEndUser.getNumberOfEvents() + 1);
        }
    }
}
