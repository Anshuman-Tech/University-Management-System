package com.ums.university.management.system.Service.Impl;

import com.ums.university.management.system.DTO.StudentDTO;
import com.ums.university.management.system.Entity.Guardian;
import com.ums.university.management.system.Entity.Student;
import com.ums.university.management.system.Error.StudentAlreadyExists;
import com.ums.university.management.system.Repository.StudentRepository;
import com.ums.university.management.system.Service.DAO.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudent(String studentId) {
        return null;
    }

    @Override
    public Student addStudent(StudentDTO studentDto) throws StudentAlreadyExists {
        Student existingStudent = studentRepository.findByEmailId(studentDto.getEmailId());
        if(existingStudent==null){
            throw new StudentAlreadyExists("Student already exists! Check the emailId");
        }
        Guardian guardian = Guardian.builder()
                .name(studentDto.getGuardianName())
                .phone(studentDto.getGuardianPhone())
                .build();

        Student student = Student.builder()
                .firstName(studentDto.getFirstName())
                .lastname(studentDto.getLastName())
                .emailId(studentDto.getEmailId())
                .dob(studentDto.getDob())
                .phone(studentDto.getPhone())
                .guardian(guardian)
                .build();
        return studentRepository.save(student);
    }
}
