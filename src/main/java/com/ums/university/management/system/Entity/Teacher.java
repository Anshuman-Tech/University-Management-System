package com.ums.university.management.system.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_sequence",
    sequenceName = "teacher_sequence",
    allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false, length = 10)
    private String phone;

    @Column(nullable = false)
    private Double salary;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",
    referencedColumnName = "courseId")
    private Course course;
}
