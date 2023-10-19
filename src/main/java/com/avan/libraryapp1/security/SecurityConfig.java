package com.avan.libraryapp1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    private static final String LOGIN_PAGE_URL = "/login"; // Defining constant

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers(LOGIN_PAGE_URL, "/register").permitAll() // Using constant
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage(LOGIN_PAGE_URL) // Using constant
                .defaultSuccessUrl("/home")
                .permitAll()
            .and()
            .logout()
                .logoutSuccessUrl(LOGIN_PAGE_URL) // Using constant
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            .and()
            .sessionManagement()
                .invalidSessionUrl(LOGIN_PAGE_URL) // Using constant
                .sessionFixation().migrateSession()
                .maximumSessions(1).expiredUrl(LOGIN_PAGE_URL) // Using constant
                .and()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .enableSessionUrlRewriting(false)
                .sessionAuthenticationErrorUrl(LOGIN_PAGE_URL); // Using constant
    }
}
