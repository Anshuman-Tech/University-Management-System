package com.ums.university.management.system.Controller;

import com.ums.university.management.system.DTO.UserDTO;
import com.ums.university.management.system.Entity.Role;
import com.ums.university.management.system.Entity.User;
import com.ums.university.management.system.Error.RoleNotFound;
import com.ums.university.management.system.Error.UserNotFound;
import com.ums.university.management.system.Service.DAO.EmailService;
import com.ums.university.management.system.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private EmailService emailService;

    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String emailId){
        User user = userServiceImpl.getUser(emailId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/register")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO){
        User savedUser = userServiceImpl.addUser(userDTO);
        emailService.simpleEmail(savedUser.getEmailId(),"You have been registered successfully with userName - "+userDTO.getEmailId(),"Registered Successfully");
        return new ResponseEntity("User created successfully",HttpStatus.OK);
    }

    @PostMapping("/assignRole/{userId}")
    public ResponseEntity<String> assignRole(@PathVariable("userId") String userId,String role) throws UserNotFound, RoleNotFound {
        userServiceImpl.assignRole(userId,role);
        return ResponseEntity.status(HttpStatus.OK).body("User role updated successfully");
    }
}
