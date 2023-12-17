package com.grhncnrbs.endtoendmvcapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class EndToEndSecurityDemo {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.disable())
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                        .requestMatchers("/", "/registration/**").permitAll()
                        .anyRequest().anonymous())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/").permitAll())
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/logout"); //Hata verirse (new AntPathRequestMatcher("/logout") dene
        return http.build();
    }
}
