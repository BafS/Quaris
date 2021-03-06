package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.RegistrationsApi;
import ch.heigvd.quaris.api.dto.RegistrationDTO;
import ch.heigvd.quaris.api.dto.RegistrationSummaryDTO;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.models.Application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Olivier Liechti
 */
@RestController
public class RegistrationsEndpoint implements RegistrationsApi {

    @Autowired
    private ApplicationRepository applicationsRepository;

    @Override
    public ResponseEntity<List<RegistrationSummaryDTO>> registrationsGet() {
        List<RegistrationSummaryDTO> result = new ArrayList<>();
        for (Application application : applicationsRepository.findAll()) {
            RegistrationSummaryDTO rs = new RegistrationSummaryDTO();
            rs.setApplicationName(application.getName());
            result.add(rs);
        }
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<Void> registrationsPost(@RequestBody RegistrationDTO registration) {
        System.out.println(registration);
        if(registration.getPassword() != null && registration.getApplicationName() != null && registration.getPassword().length() >= 5) {
            Application newApplication = new Application();
            newApplication.setName(registration.getApplicationName());
            String passwordHash = registration.getPassword(); // TODO hash password
            newApplication.setPasswordHash(passwordHash);

            System.out.println("> New registration:");
            System.out.println(registration); // DEV

            try {
                applicationsRepository.save(newApplication);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } catch (DataIntegrityViolationException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getClass());
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }

}
