//package com.spring.security.basicauth;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    /*
//    This is a basic authentication where we are using an AuthenticationManagerBuilder
//    to create a custom AuthenticationManager configuration.
//
//    Here we extend the WebSecurityConfigurerAdapter class to override the configure method and
//            provide our custom AuthenticationManagerBuilder.
//
//    In this, builder will require  authentication (inMemoryAuthentication), username, password and role.
//
//    As password cannot be given as hardcoded, PasswordEncoder is added.
// */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("ethan")
//                .password("ethan123")
//                .roles("ADMIN")
//                .and()
//                .withUser("Benji")
//                .password("dunn123")
//                .roles("USER");
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    /*
//    Authorization Implementation
//    Here we are overriding configure method with httpSecurity to authorize requests
//    our use case is
//    API     Access
//    /        All (unauthenticated)
//    /user    User and admin role (authenticated)
//    /admin   only admin role (authenticated)
//
//    Here we use ant matchers to allow specific api's for specific users.
//     */
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasAnyRole("USER","ADMIN")
//                .antMatchers("/").permitAll()
//                .and()
//                .formLogin();
//    }
//}