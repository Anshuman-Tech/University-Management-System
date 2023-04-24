package com.ums.university.management.system.Service.DAO;


import com.ums.university.management.system.DTO.StudentDTO;
import com.ums.university.management.system.Entity.Student;
import com.ums.university.management.system.Error.StudentAlreadyExists;
import com.ums.university.management.system.Error.StudentNotFound;

import java.util.List;

public interface StudentService {

    Student addStudent(StudentDTO studentDto) throws StudentAlreadyExists;

    Student getStudent(String emailId);

    List<Student> getAllStudents(int pageNumber,int pageSize,String sortBy);

    Student updateStudent(Long studentId,StudentDTO studentDTO) throws StudentNotFound;

    Student updateStudentPhone(Long studentId, String phone) throws StudentNotFound;

    void deleteStudentByStudentId(Long studentId) throws StudentNotFound;

    void deleteStudentByEmailId(String emailId) throws StudentNotFound;
}
