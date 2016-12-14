package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.dto.User;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.repositories.EndUserRepository;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.models.EndUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Olivier Liechti
 */
@RestController
public class UsersEndpoint {
        //implements UsersApi {

  private final ApplicationRepository applicationRepository;
  private final EndUserRepository endUserRepository;

  public UsersEndpoint(ApplicationRepository applicationRepository, EndUserRepository endUserRepository) {
    this.applicationRepository = applicationRepository;
    this.endUserRepository = endUserRepository;
  }

  // @Override
  public ResponseEntity findUserById(@RequestHeader(value="X-Gamification-Token") String xGamificationToken, @PathVariable("id") String userId) {
    String targetApplicationName = xGamificationToken;
    Application targetApplication = applicationRepository.findByName(targetApplicationName);
    if (targetApplication == null || userId == null) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
    EndUser endUser = endUserRepository.findByApplicationNameAndIdInApplication(targetApplicationName, userId);
    User user = new User();
    user.setUserId(endUser.getIdInGamifiedApplication());
    user.setNumberOfEvents(endUser.getNumberOfEvents());
    return ResponseEntity.ok(user);
  }

}
