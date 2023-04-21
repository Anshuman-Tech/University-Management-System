package com.ums.university.management.system.Controller;


import com.ums.university.management.system.DTO.StudentDTO;
import com.ums.university.management.system.Entity.Student;
import com.ums.university.management.system.Error.StudentAlreadyExists;
import com.ums.university.management.system.Service.DAO.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO studentDto) throws StudentAlreadyExists {
        Student student = studentService.addStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
