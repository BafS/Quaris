package ch.heigvd.quaris.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Fabien Salathe on 26.01.17.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter extends OncePerRequestFilter {

    /**
     * Enable CORS
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Access-Control-Request-Method, Authorization");
        response.addHeader("Access-Control-Expose-Headers", "Origin, Content-Type, Accept, Access-Control-Request-Method, Authorization");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");

        filterChain.doFilter(request, response);
    }

}
