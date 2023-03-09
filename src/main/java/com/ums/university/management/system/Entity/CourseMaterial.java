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
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "course_material_id")
    private Long courseMaterialId;

    @Column(name = "name",nullable = false)
    private String courseMaterialName;

    @ManyToOne(cascade = CascadeType.ALL,
    fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",
    referencedColumnName = "courseId")
    private Course course;

}
