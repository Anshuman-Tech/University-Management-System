package com.ums.university.management.system.Controller;

import com.ums.university.management.system.DTO.RoleDTO;
import com.ums.university.management.system.Entity.Role;
import com.ums.university.management.system.Service.Impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @PostMapping("/addRole")
//    @PreAuthorize("hasAnyAuthority('Admin','Normal')")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity addRole(@RequestBody RoleDTO roleDTO){
        Role role = roleServiceImpl.addRole(roleDTO);
        return new ResponseEntity("Role: " + role.getRoleName() + " has been added successfully", HttpStatus.OK);
    }

    @GetMapping("/getRoles")
    @PreAuthorize("hasAuthority('Admin')") //Only a user with role as Admin can access this route.
    public List<Role> getRoles() {
       return roleServiceImpl.getRoles();
    }
}
