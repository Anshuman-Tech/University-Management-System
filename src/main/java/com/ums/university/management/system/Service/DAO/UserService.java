package com.ums.university.management.system.Service.DAO;

import com.ums.university.management.system.DTO.UserRoleDTO;
import com.ums.university.management.system.Entity.User;

import java.util.List;

public interface UserService {

    User getUser(String emailId);

    List<User> getAllUsers();

    void addUser(User user);

    void assignRole(UserRoleDTO userRoleDTO);
}
