package com.virtual.system.inmobiliaria.web.app.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //Cuando se inicie la app, pueda procesar la logica de la seguridad
@Configuration
public class SecurityConfig {

    @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;

    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;

    @Value("${service.security.secure-key-username-2}")
    private String SECURE_KEY_USERNAME2;

    @Value("${service.security.secure-key-password-2}")
    private String SECURE_KEY_PASSWORD2;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(
          AuthenticationManagerBuilder.class
        );

        authenticationManagerBuilder.inMemoryAuthentication()

                .withUser(SECURE_KEY_USERNAME)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
                .and()
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("admin"))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
                .and()
                .withUser("dev")
                .password(new BCryptPasswordEncoder().encode("dev"))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_DEV"))
                .and()
                .passwordEncoder(new BCryptPasswordEncoder());


        return http.build();

    }

}
