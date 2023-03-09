package com.ums.university.management.system.Service.Impl;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.ums.university.management.system.Entity.User;
import com.ums.university.management.system.Repository.UserRepository;
import com.ums.university.management.system.Service.DAO.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
       User user =  userRepository.findById(emailId).get();
       if(user!=null){
           CustomUserDetails customUserDetails = new CustomUserDetails(user);
           return customUserDetails;
       }
        throw new UsernameNotFoundException("User not found");
    }
}
