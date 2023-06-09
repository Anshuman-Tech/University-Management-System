package com.ums.university.management.system.Service.Impl;

import com.ums.university.management.system.Entity.Role;
import com.ums.university.management.system.Repository.RoleRepository;
import com.ums.university.management.system.Service.DAO.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    //Add a new role
    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }


    //Get the list of all the roles
    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
