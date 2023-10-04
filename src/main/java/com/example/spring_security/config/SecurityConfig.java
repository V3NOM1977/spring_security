package com.example.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService getUsers() {
        UserDetails user = User.builder()
                .username("user")
                .password(getPasswordEncoder().encode("123"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(getPasswordEncoder().encode("abc"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    // @Bean
    // public InMemoryUserDetailsManager getMoreUsers() {
    // UserDetails user1 = User.withUsername("user1")
    // .password(getPasswordEncoder().encode("user1Pass"))
    // .roles("USER")
    // .build();
    // UserDetails user2 = User.withUsername("user2")
    // .password(getPasswordEncoder().encode("user2Pass"))
    // .roles("USER")
    // .build();
    // UserDetails admin = User.withUsername("admin")
    // .password(getPasswordEncoder().encode("adminPass"))
    // .roles("ADMIN")
    // .build();
    // return new InMemoryUserDetailsManager(user1, user2, admin);
    // }

}
