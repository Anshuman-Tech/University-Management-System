package com.ums.university.management.system.Service.DAO;

import com.ums.university.management.system.Entity.User;
import com.ums.university.management.system.Error.RoleNotFound;
import com.ums.university.management.system.Error.UserNotFound;

import java.util.List;

public interface UserService {

    User getUser(String emailId);

    List<User> getAllUsers();

    void addUser(User user);

    void assignRole(String userId,String role) throws RoleNotFound, UserNotFound;
}
