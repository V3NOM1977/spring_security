package com.example.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.spring_security.config.custom_authentication.filters.CustomTokenAuthFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private final CustomTokenAuthFilter customTokenAuthFilter;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> {
                    csrf.disable();
                })
                .addFilterAt(customTokenAuthFilter, BasicAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> {
                    auth
                            .requestMatchers("/error").permitAll()
                            .anyRequest().authenticated();
                });
        return http.build();
    }

    // CONFIG FOR HTTPBASIC LOGIN.
    // @Bean
    // public SecurityFilterChain config(HttpSecurity http) throws Exception {
    // http
    // .csrf(csrf -> {
    // csrf.disable();
    // })
    // .authorizeHttpRequests(auth -> {
    // auth
    // .requestMatchers("/error").permitAll()
    // .anyRequest().authenticated();
    // })
    // .httpBasic(Customizer.withDefaults());
    // return http.build();
    // }

}
