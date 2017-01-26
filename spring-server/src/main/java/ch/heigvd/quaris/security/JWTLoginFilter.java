package ch.heigvd.quaris.security;

import ch.heigvd.quaris.api.dto.RegistrationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fabien Salathe on 17.12.16.
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

    private TokenAuthenticationService tokenAuthenticationService;

    public JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authenticationManager);
        tokenAuthenticationService = new TokenAuthenticationService();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws AuthenticationException, IOException, ServletException {

        // For "pre-flight" requests
        if (!httpServletRequest.getMethod().equals("OPTIONS")) {
            RegistrationDTO credentials = new ObjectMapper().readValue(httpServletRequest.getInputStream(), RegistrationDTO.class);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credentials.getApplicationName(), credentials.getPassword());
            return getAuthenticationManager().authenticate(token);
        }

        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication)
            throws IOException, ServletException {
        String name = authentication.getName();
        tokenAuthenticationService.addAuthentication(response, name);
    }
}