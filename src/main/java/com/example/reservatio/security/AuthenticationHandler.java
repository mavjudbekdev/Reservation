package com.example.reservatio.security;

import com.example.reservatio.role.Role;
import com.example.reservatio.user.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
    SimpleUrlAuthenticationSuccessHandler userSuccessHandler =
            new SimpleUrlAuthenticationSuccessHandler("/auth/index");
    SimpleUrlAuthenticationSuccessHandler adminSuccessHandler =
            new SimpleUrlAuthenticationSuccessHandler("/auth/admin");

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {


        User user = (User) authentication.getPrincipal();
        Role role = user.getRole();


        if (role.name().equals("ROLE_ADMIN")) {
            this.adminSuccessHandler.onAuthenticationSuccess(request, response, authentication);
        } else {
            this.userSuccessHandler.onAuthenticationSuccess(request, response, authentication);
        }


    }
}

