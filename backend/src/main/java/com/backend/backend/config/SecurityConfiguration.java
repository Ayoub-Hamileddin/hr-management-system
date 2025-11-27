package com.backend.backend.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http
        .csrf(csrf -> csrf.disable())   
        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        )
        .authorizeRequests(
            authorize -> authorize.requestMatchers("/api/auth/login","/api/auth/register","/api/auth/refresh").permitAll()
            .anyRequest().authenticated()
        )


                        /*
                        *       it verifiying the credentials provided by a user sach as username and password against a known source of inforamation like a database .
                        *       if the authentiction success it return Authentication object represnting the authentication user
                        */      
        .authenticationProvider(authenticationProvider)

        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    CorsConfigurationSource configurationSource(){

        CorsConfiguration configuration= new CorsConfiguration();
            configuration.setAllowedOrigins(List.of("http://localhost:5173","http://localhost:8080"));
            configuration.setAllowedMethods(List.of("POST","GET","PUT","DELETE"));
            configuration.setAllowCredentials(true);
            configuration.addAllowedHeader("*");
            UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);

            return source;
    }

}
