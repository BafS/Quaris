package ch.heigvd.quaris.api;

import ch.heigvd.quaris.api.definitions.UsersApi;
import ch.heigvd.quaris.api.dto.User;
import ch.heigvd.quaris.repositories.EndUserRepository;
import ch.heigvd.quaris.models.EndUser;
import ch.heigvd.quaris.services.ApplicationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersEndpoint implements UsersApi {

    @Autowired
    private final EndUserRepository endUserRepository = null;

    @Override
    public ResponseEntity findUserById(@PathVariable("id") String userId) {
        String targetApplicationName = new ApplicationService().getCurrentApplicationName();

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        System.out.println("[i] Find user from app " + targetApplicationName + ", with id: " + userId);

        EndUser endUser = endUserRepository.findByApplicationNameAndIdInApplication(targetApplicationName, userId);

        if (endUser == null) {
            return ResponseEntity.notFound().build();
        }

        User userDTO = new ModelMapper().map(endUser, User.class);

        return ResponseEntity.ok(userDTO);
    }

}
