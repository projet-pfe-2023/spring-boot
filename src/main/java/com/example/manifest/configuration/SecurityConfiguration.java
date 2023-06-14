package com.example.manifest.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;




@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {


    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtFilter;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
     http
             .csrf()
             .disable()
             .authorizeHttpRequests()
             .requestMatchers("/api/test/auth/**")
             .permitAll()
             .requestMatchers("/api/test/User/**")
             .permitAll()
             .requestMatchers("/api/test/Marchandise/**")
             .permitAll()
             .requestMatchers("/api/test/Manifest/**")
             .permitAll()
             .requestMatchers("/api/test/Connaissement/**")
             .permitAll()
             .requestMatchers("/api/test/Intervenant/**")
             .permitAll()
             .requestMatchers("/api/test/Conteneur/**")
             .permitAll()
             .requestMatchers("/api/test/File/**")
             .permitAll()
             .anyRequest()
             .authenticated()
             .and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             .and()
             .authenticationProvider(authenticationProvider)
             .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
             .logout()
             .logoutUrl("/api/test/auth/logout")
             .addLogoutHandler(logoutHandler)
             .logoutSuccessHandler(((request, response, authentication) -> SecurityContextHolder.clearContext()))
                ;


        return http.build();
    }


}