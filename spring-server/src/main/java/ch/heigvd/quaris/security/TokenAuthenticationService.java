package ch.heigvd.quaris.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by Fabien Salathe on 17.12.16.
 */
public class TokenAuthenticationService {

    private final long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 1; // 1 day
    private final String SECRET = "super_secret_token_vzHWPUnc5jyTNzzhVKxtQguw";
    private final String HEADER_KEY = "Authorization";

    public void addAuthentication(HttpServletResponse response, String username) {
        // Generate a token
        String jwt = Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .compact();

        // Set authorization header
        response.setStatus(HttpStatus.NO_CONTENT.value());
        response.addHeader(HEADER_KEY, "Bearer " + jwt);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_KEY);

        if (token != null && token.length() > 10) {
            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            if (username != null) {
                return new AuthenticatedUser(username);
            }
        }

        return null;
    }
}