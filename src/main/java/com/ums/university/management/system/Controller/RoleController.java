package com.ums.university.management.system.Controller;

import com.ums.university.management.system.DTO.RoleDTO;
import com.ums.university.management.system.Entity.Role;
import com.ums.university.management.system.Service.Impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @PostMapping("/addRole")
    public ResponseEntity addRole(@RequestBody RoleDTO roleDTO){
        Role role = new Role(roleDTO.getRoleName());
        roleServiceImpl.addRole(role);
        return new ResponseEntity("Role added successfully", HttpStatus.OK);
    }

    @GetMapping("/getRoles")
    public List<Role> getRoles(){
       return roleServiceImpl.getRoles();
    }
}
