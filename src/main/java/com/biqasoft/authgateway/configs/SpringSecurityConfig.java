/*
 * Copyright (c) 2016. com.biqasoft
 */

package com.biqasoft.authgateway.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private ReactiveAuthenticationManager authenticationManager;

    @Autowired
    private ServerSecurityContextRepository securityContextRepository;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.formLogin().disable();
        http.csrf().disable();
        http.logout().disable();

        // Add custom security.
        http.authenticationManager(this.authenticationManager);
        http.securityContextRepository(this.securityContextRepository);

        // TODO: antMatchers(HttpMethod.OPTIONS).permitAll()
        // http.authorizeExchange().pathMatchers("/auth/**").permitAll();
        http.authorizeExchange().anyExchange().authenticated();

        return http.build();
    }

}
