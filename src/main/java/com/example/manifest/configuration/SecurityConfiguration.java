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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


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
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}