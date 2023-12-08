package com.example.reservatio.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final String[] openPathUrl = {"/","/auth/sign-in", "/auth/sign-up","/css/**"};

    private final AuthenticationHandler successHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security
                .authorizeHttpRequests(
                        registry -> registry
                                .requestMatchers(openPathUrl).permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(
                        loginConfig -> loginConfig
                                .loginPage("/auth/sign-in")
                                .successHandler(successHandler)
                                .loginProcessingUrl("/auth/sign-in")
                                .usernameParameter("email")
                                .passwordParameter("password")
                )

                .logout(
                        logoutConfig -> logoutConfig
                                .logoutUrl("/sign-out")
                                .logoutSuccessUrl("/sign-in")
                )
                .rememberMe(
                        rememberMeConfig -> rememberMeConfig
                                .rememberMeCookieName("rememberMe")
                                .tokenValiditySeconds(1 * 60 * 60 * 24)
                                .rememberMeParameter("rememberMe")
                )
                .build();

    }
}