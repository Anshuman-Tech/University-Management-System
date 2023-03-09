package com.ums.university.management.system.Service.DAO;

import com.ums.university.management.system.Entity.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    List<Role> getRoles();
}
