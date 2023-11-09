package com.example.spring_security.config.custom_authentication.managers;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.spring_security.config.custom_authentication.providers.CustomTokenAuthProvider1;
import com.example.spring_security.config.custom_authentication.providers.CustomTokenAuthProvider2;

import lombok.AllArgsConstructor;

// MANAGER CAN HAVE N NUMBER OF PROVIDERS.
@Component
@AllArgsConstructor
public class CustomTokenAuthManeger implements AuthenticationManager {

    private final CustomTokenAuthProvider1 customTokenAuthProvider1;

    private final CustomTokenAuthProvider2 customTokenAuthProvider2;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (customTokenAuthProvider1.supports(authentication.getClass())) {
            return customTokenAuthProvider1.authenticate(authentication);
        } else {
            return customTokenAuthProvider2.authenticate(authentication);
        }
    }

}
