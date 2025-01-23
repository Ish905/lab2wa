package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserDetailsServiceConfig {
    private final PasswordEncoder passwordEncoder; // Inject the PasswordEncoder bean

    public UserDetailsServiceConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Create a user with username "user" and password "password"
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password")) // Use the injected PasswordEncoder
                .roles("USER")
                .build();

        // Return an InMemoryUserDetailsManager with the created user
        return new InMemoryUserDetailsManager(user);
    }
}