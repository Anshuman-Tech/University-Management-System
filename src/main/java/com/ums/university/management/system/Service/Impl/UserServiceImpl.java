package com.ums.university.management.system.Service.Impl;

import com.ums.university.management.system.DTO.UserRoleDTO;
import com.ums.university.management.system.Entity.Role;
import com.ums.university.management.system.Entity.User;
import com.ums.university.management.system.Repository.RoleRepository;
import com.ums.university.management.system.Repository.UserRepository;
import com.ums.university.management.system.Service.DAO.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public User getUser(String emailId) {
        return userRepository.findById(emailId).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void assignRole(UserRoleDTO userRoleDTO){
        Role role = roleRepository.findById(userRoleDTO.getRoleName()).get();
        User user = userRepository.findById(userRoleDTO.getEmailId()).get();
        if(user==null || role==null){
            return;
        }
        List<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);
    }
}
