package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
 import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.security.JwtAuthFilter;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .cors(cors -> {})
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth

            	    
            	    .requestMatchers("/api/auth/**").permitAll()

            	    
            	    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

            	   

            	    
            	    .requestMatchers(HttpMethod.GET, "/api/rooms/**").permitAll()
            	    .requestMatchers(HttpMethod.PUT, "/api/rooms/**").hasAuthority("ROLE_ADMIN")
            	    .requestMatchers(HttpMethod.POST, "/api/rooms/**").hasAuthority("ROLE_ADMIN")
            	    .requestMatchers(HttpMethod.PATCH, "/api/rooms/**").hasAuthority("ROLE_ADMIN")
            	    .requestMatchers(HttpMethod.DELETE, "/api/rooms/**").hasAuthority("ROLE_ADMIN")

            	   
            	    .requestMatchers("/api/student/**")
            	        .hasAuthority("ROLE_STUDENT")

            	  
            	    .requestMatchers("/api/hostels/**").permitAll()
            	    
            	    .requestMatchers("/api/beds/**").permitAll()
            	    
            	    .requestMatchers(HttpMethod.GET,"/api/beds/**").permitAll()
            	    .requestMatchers(HttpMethod.POST, "/api/beds/**").hasAuthority("ROLE_ADMIN")
            	    .requestMatchers(HttpMethod.PATCH, "/api/beds/**").hasAuthority("ROLE_ADMIN")
            	    .requestMatchers(HttpMethod.DELETE, "/api/beds/**").hasAuthority("ROLE_ADMIN")
            	    

            	    .anyRequest().authenticated()
            	);


        http.addFilterBefore(
            jwtAuthFilter,
            UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }
}
