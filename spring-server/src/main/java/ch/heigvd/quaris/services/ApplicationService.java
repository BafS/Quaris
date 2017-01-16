package ch.heigvd.quaris.services;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by Fabien Salathe on 17.01.17.
 */
@Service
public class ApplicationService {

//    @Autowired
//    private ApplicationRepository applicationsRepository = null;

    public String getCurrentApplicationName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String targetApplicationName = "";
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            targetApplicationName = authentication.getName();
        }

        return targetApplicationName;
    }

//    public Application getCurrentApplication() {
//        System.out.println("targetApplicationName: " + targetApplicationName); // DEBUG
//
//        return applicationRepository.findByName(targetApplicationName);
//    }
}
