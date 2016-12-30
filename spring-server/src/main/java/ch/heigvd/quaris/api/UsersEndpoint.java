package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.dto.User;
import ch.heigvd.quaris.repositories.ApplicationRepository;
import ch.heigvd.quaris.repositories.EndUserRepository;
import ch.heigvd.quaris.models.Application;
import ch.heigvd.quaris.models.EndUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersEndpoint implements UsersApi {

    @Autowired
    private final ApplicationRepository applicationRepository = null;

    @Autowired
    private final EndUserRepository endUserRepository = null;

    @Override
    public ResponseEntity findUserById(@PathVariable("id") String userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String targetApplicationName = "";
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            targetApplicationName = authentication.getName();
        }

        System.out.println("targetApplicationName: " + targetApplicationName); // DEBUG

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
