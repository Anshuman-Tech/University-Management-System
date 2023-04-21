package com.ums.university.management.system.Service.DAO;


import com.ums.university.management.system.DTO.StudentDTO;
import com.ums.university.management.system.Entity.Student;
import com.ums.university.management.system.Error.StudentAlreadyExists;

import java.util.List;

public interface StudentService {

    Student addStudent(StudentDTO studentDto) throws StudentAlreadyExists;

    Student getStudent(String studentId);

    List<Student> getAllStudents();

}
