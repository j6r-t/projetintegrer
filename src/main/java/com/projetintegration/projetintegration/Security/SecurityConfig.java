package com.projetintegration.projetintegration.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF protection (optional, but recommended for APIs)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/UtilAct/register", "/UtilAct/login", "/SocieteAct/ajout_societe").permitAll() // Allow access to these endpoints without authentication
                        .anyRequest().authenticated() // Require authentication for all other endpoints

                );

        return http.build();
    }
}