package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.dto.Credentials;
import ch.heigvd.quaris.api.dto.Token;
import ch.heigvd.quaris.dao.ApplicationRepository;
import ch.heigvd.quaris.model.Application;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Olivier Liechti
 */
@RestController
public class AuthEndpoint implements AuthApi {

  private ApplicationRepository applicationsRepository;

  public AuthEndpoint(ApplicationRepository applicationsRepository) {
    this.applicationsRepository = applicationsRepository;
  }

  @Override
  public ResponseEntity authenticateApplicationAndGetToken(@RequestBody Credentials body) {
    String applicationName = body.getApplicationName();
    String password = body.getPassword();
    Application application = applicationsRepository.findByName(applicationName); // We are not authenticating yet!
    if (application != null) {
      Token token = new Token();
      token.setApplicationName(application.getName());
      return ResponseEntity.ok(token);
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

}
