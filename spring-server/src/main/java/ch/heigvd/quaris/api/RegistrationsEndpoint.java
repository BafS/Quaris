package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.dto.Registration;
import ch.heigvd.quaris.api.dto.RegistrationSummary;
import ch.heigvd.quaris.dao.ApplicationRepository;
import ch.heigvd.quaris.model.Application;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Olivier Liechti
 */
@RestController
public class RegistrationsEndpoint implements RegistrationsApi {

  private ApplicationRepository applicationsRepository;

  public RegistrationsEndpoint(ApplicationRepository applicationsRepository) {
    this.applicationsRepository = applicationsRepository;
  }

  @Override
  public ResponseEntity<List<RegistrationSummary>> registrationsGet() {
    List<RegistrationSummary> result = new ArrayList<>();
    for (Application application : applicationsRepository.findAll()) {
      RegistrationSummary rs = new RegistrationSummary();
      rs.setApplicationName(application.getName());
      result.add(rs);
    }
    return ResponseEntity.ok(result);
  }

  ;

  @Override
  public ResponseEntity<Void> registrationsPost(@RequestBody Registration registration) {
    Application newApplication = new Application();
    newApplication.setName(registration.getApplicationName());
    String passwordHash = registration.getPassword(); // LOL
    newApplication.setPasswordHash(passwordHash);
    try {
      applicationsRepository.save(newApplication);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (DataIntegrityViolationException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getClass());
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }

}
