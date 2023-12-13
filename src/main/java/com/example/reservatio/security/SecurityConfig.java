package com.example.reservatio.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final String[] openPathUrl = {"/", "/car", "/car/car-home", "/car/get-all-car", "/auth/sign-in", "/auth/sign-up", "/css/**", "/image/**"};

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
                                .logoutUrl("/auth/sign-out")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/sign-out"))
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
