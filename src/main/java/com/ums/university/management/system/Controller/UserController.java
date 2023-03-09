package com.ums.university.management.system.Controller;

import com.ums.university.management.system.DTO.UserDTO;
import com.ums.university.management.system.DTO.UserRoleDTO;
import com.ums.university.management.system.Entity.Role;
import com.ums.university.management.system.Entity.User;
import com.ums.university.management.system.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class UserController{

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/getUser/{id}")
    User getUser(@PathVariable("id") String emailId){
        return userServiceImpl.getUser(emailId);
    }

    @PostMapping("/register")
    ResponseEntity addUser(@RequestBody UserDTO userDTO){
        User user = User.builder()
                .emailId(userDTO.getEmailId())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .roles(Arrays.asList(new Role("Normal")))
                .build();
        userServiceImpl.addUser(user);
        return new ResponseEntity("User created successfully",HttpStatus.OK);
    }

    @PostMapping("/assignRole")
    void assignRole(@RequestBody UserRoleDTO userRoleDTO){
        userServiceImpl.assignRole(userRoleDTO);
    }
}
