package com.example.spring_security.config.custom_authentication.filters;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.spring_security.config.custom_authentication.authentications.CustomTokenAuth1;
import com.example.spring_security.config.custom_authentication.authentications.CustomTokenAuth2;
import com.example.spring_security.config.custom_authentication.managers.CustomTokenAuthManeger;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomTokenAuthFilter extends OncePerRequestFilter {

    private final CustomTokenAuthManeger customTokenAuthManeger;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token1 = request.getHeader("auth-token-1");
        String token2 = request.getHeader("auth-token-2");

        Authentication authentication;

        if (token1 != null) {
            CustomTokenAuth1 customTokenAuth1 = new CustomTokenAuth1(false, token1);
            authentication = customTokenAuthManeger.authenticate(customTokenAuth1);
        }  else {
            CustomTokenAuth2 customTokenAuth2 = new CustomTokenAuth2(false, token2);
            authentication = customTokenAuthManeger.authenticate(customTokenAuth2);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

}
