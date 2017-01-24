package ch.heigvd.quaris.security;

import ch.heigvd.quaris.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Fabien Salathe on 17.12.16.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ApplicationRepository applicationsRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // disable caching
        http.headers().cacheControl();

        http.csrf().disable() // disable csrf for our requests.
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/registrations").permitAll() // Can create a new app
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .anyRequest().authenticated()
                .and()
                // We filter the api/auth requests
                .addFilterBefore(
                        new JWTLoginFilter("/auth", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class
                )
                // And filter other requests to check the presence of JWT in header
                .addFilterBefore(
                        new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class
                );
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(applicationsRepository::findByName).passwordEncoder(new BCryptPasswordEncoder());
    }
}