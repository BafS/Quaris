package ch.heigvd.quaris.services;

import ch.heigvd.quaris.api.dto.Event;
import ch.heigvd.quaris.repositories.EndUserRepository;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.models.EndUser;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Olivier Liechti
 */
@Service
public class EventProcessor {

  private final EndUserRepository endUsersRepository;

  public EventProcessor(EndUserRepository endUsersRepository) {
    this.endUsersRepository = endUsersRepository;
  }

  @Async
  @Transactional
  public void processEvent(Application application, Event event) {
    EndUser targetEndUser = endUsersRepository.findByApplicationNameAndIdInApplication(application.getName(), event.getUserId());
    if (targetEndUser == null) {
      targetEndUser = new EndUser();
      targetEndUser.setApplication(application);
      targetEndUser.setIdInGamifiedApplication(event.getUserId());
      targetEndUser.setNumberOfEvents(1);
      endUsersRepository.save(targetEndUser);
    } else {
      targetEndUser.setNumberOfEvents(targetEndUser.getNumberOfEvents()+1);
    }

  }

}
