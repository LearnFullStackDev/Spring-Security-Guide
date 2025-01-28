//package com.spring.security.jpa;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
///*
//This class implements the UserDetails class So that
//we can override the methods for getting authorities, username, password and other user details.
//
//In this class we are receiving the User we got from the DB
//using that we are assigning the userDetails to the local variables in this class
//and returning these values to UserDetailService to validate.
// */
//
//
//public class JPAUserDetails implements UserDetails {
//
//    private String username;
//    private String password;
//    private List<GrantedAuthority> roles;
//    private boolean active;
//
//    public JPAUserDetails(User user) {
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//        this.roles = Arrays.stream(user.getRoles().split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//        this.active = user.isActive();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
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
//        return active;
//    }
//}
