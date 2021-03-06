package com.mancio.MyBank.OAuth2conf;

import com.mancio.MyBank.Service.UserServCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServCredentials userservcredentials;

    private static final String SALT = "ib$iobio#$@#$";

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userservcredentials).passwordEncoder(passwordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10, rangen());
    }

    private SecureRandom rangen(){
        SecureRandom random = new SecureRandom();
        random.nextBytes(SALT.getBytes());
        return random;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().
                antMatchers(PUB_LINK).permitAll().anyRequest().authenticated().
                antMatchers(ADMIN_LINK).hasRole("ADMIN").
                antMatchers(USER_LINK).hasRole("USER");


    }

    // link that do not require authorization
    private static final String[] PUB_LINK = {
        "/",
        "/login"
    };

    private static final String[] ADMIN_LINK = {
        "/admin"
    };

    private static final String[] USER_LINK = {
        "/user",
        "/transfer",
        "/mydata"
    };



}