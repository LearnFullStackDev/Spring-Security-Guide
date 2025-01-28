//package com.spring.security.jpa;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
///*
//This class implements the UserDetailService with which we need to implement the loadUserByName method
//where we can provide our own implementation of UserDetails.
// */
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    /*
//    Here we have just created MyUserDetails class and passing the username to it.
//    This class will validate the given username with the given conditions in that class.
//     */
//
////    @Override
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        return new MyUserdetails(username);
////    }
//
//    /*
//    Here we are passing the username to the repository class to get the user details from DB.
//    After receiving the userDetails, null check and throw UserNameNotFoundException with a message.
//
//    Then the user is passed to the JPAUserDetails class where we are mapping the user object to UserDetails object.
//     */
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Optional<User> user = userRepository.findByUsername(username);
//
//        user.orElseThrow(() -> new UsernameNotFoundException("User "+username + " Not Found"));
//
//        return user.map(JPAUserDetails::new).get();
//
//    }
//}
