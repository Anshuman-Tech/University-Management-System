package com.ums.university.management.system.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(name = "student_tbl")
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "email_id",nullable = false, unique = true)
    private String emailId;

    @Column(name = "password",length = 15,nullable = false)
    private String password;

    @Column(nullable = false)
    private String dob;
    @Column(name = "phone_number", nullable = false, length = 10)
    private String phone;

    @Transient
    Guardian guardian;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    )
    private List<Course> courses;
}
