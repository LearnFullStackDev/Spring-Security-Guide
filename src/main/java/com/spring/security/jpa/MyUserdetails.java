//package com.spring.security.jpa;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
///*
//This class implements the UserDetails class So that
//we can override the methods for getting authorities, username, password and other user details.
//
//In this class we are using all hardcoded values like password, roles, etc
//
//and returning these values to UserDetailService to validate.
// */
//
//public class MyUserdetails implements UserDetails {
//
//    private String username;
//
//    public MyUserdetails(String username) {
//        this.username = username;
//    }
//
//    public MyUserdetails() {}
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
//    }
//
//    @Override
//    public String getPassword() {
//        return "pass";
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
