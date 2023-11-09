package com.example.spring_security.config.custom_authentication.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.spring_security.config.custom_authentication.authentications.CustomTokenAuth1;

import lombok.extern.slf4j.Slf4j;

// PROVIDERS IMPLEMENT BUSSINESS LOGIC.
// THEY HAVE THIER OWN AUTHENTICATION.
@Slf4j
@Component
public class CustomTokenAuthProvider1 implements AuthenticationProvider {

    @Value("${app.secret.token1}")
    private String appSecretToken;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomTokenAuth1 customAuthentication = (CustomTokenAuth1) authentication;
        String token = customAuthentication.getToken();

        if (appSecretToken.equals(token)) {
            log.info("Request have valid key");
            return new CustomTokenAuth1(true, token);
        }
        throw new BadCredentialsException("Token Mismatch...!!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomTokenAuth1.class.equals(authentication);
    }

}
