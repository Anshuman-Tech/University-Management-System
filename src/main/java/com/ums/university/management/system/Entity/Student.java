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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "first_name",nullable = false,length = 50)
    private String firstName;

    @Column(name = "last_name",nullable = true)
    private String lastname;

    @Column(name = "email_id",nullable = false, unique = true)
    private String emailId;

    @Column(nullable = false)
    private String dob;

    @Column(name = "phone_number", nullable = false, length = 10)
    private String phone;

    @Embedded
    private Guardian guardian;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id",referencedColumnName = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id",referencedColumnName = "course_id")
    )
    private List<Course> courses;
}
