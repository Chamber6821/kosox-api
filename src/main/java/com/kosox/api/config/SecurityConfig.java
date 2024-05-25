package com.kosox.api.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(
            request -> request
                .requestMatchers(HttpMethod.POST, "/forms").anonymous()
                .requestMatchers(HttpMethod.GET, "/forms/**").denyAll()
                .requestMatchers(HttpMethod.GET).anonymous())
        .csrf(csrf -> csrf.ignoringRequestMatchers("/forms"))
        .build();
  }
}
