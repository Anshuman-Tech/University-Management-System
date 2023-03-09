package com.ums.university.management.system.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @Column(name = "email_address", nullable = false,unique = true)
    private String emailId;

    @Column(nullable = false,length = 15)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "email_Id",referencedColumnName = "email_address"),
            inverseJoinColumns = @JoinColumn(name = "role_name",referencedColumnName = "role_name")
    )
    private List<Role> roles;
}
