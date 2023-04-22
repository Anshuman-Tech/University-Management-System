package com.ums.university.management.system.Service.DAO;

import com.ums.university.management.system.DTO.UserDTO;
import com.ums.university.management.system.Entity.User;
import com.ums.university.management.system.Error.RoleNotFound;
import com.ums.university.management.system.Error.UserNotFound;

import java.util.List;

public interface UserService {

    User getUser(String emailId);

    List<User> getAllUsers();

    User addUser(UserDTO userDTO);

    void assignRole(String userId,String role) throws RoleNotFound, UserNotFound;
}
