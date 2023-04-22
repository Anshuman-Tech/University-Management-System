package com.ums.university.management.system.Service.Impl;

import com.ums.university.management.system.DTO.UserDTO;
import com.ums.university.management.system.Entity.Role;
import com.ums.university.management.system.Entity.User;
import com.ums.university.management.system.Error.RoleNotFound;
import com.ums.university.management.system.Error.UserNotFound;
import com.ums.university.management.system.Repository.RoleRepository;
import com.ums.university.management.system.Repository.UserRepository;
import com.ums.university.management.system.Service.DAO.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //Get user by userId
    @Override
    public User getUser(String emailId) {

        return userRepository.findById(emailId).get();
    }

    //Get the List of all users
    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    //Add a new user
    @Override
    public User addUser(UserDTO userDTO) {
        User user = User.builder()
                .emailId(userDTO.getEmailId())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .roles(Arrays.asList(new Role("Normal")))
                .build();
        return userRepository.save(user);
    }

    //Assign a role to the user
    @Override
    public void assignRole(String emailId, String role) throws RoleNotFound,UserNotFound{
        Optional<Role> role1 = roleRepository.findById(role);
        if(!role1.isPresent()){
            throw new RoleNotFound("Role does not exist");
        }
        Optional<User> user = userRepository.findById(emailId);
        if(!user.isPresent()){
            throw new UserNotFound("User does not exist");
        }
        User user1 = user.get();
        Role role2 = role1.get();

        List<Role> userRoles = user.get().getRoles();
        userRoles.add(role2);
        user1.setRoles(userRoles);
        userRepository.save(user1);
    }
}
