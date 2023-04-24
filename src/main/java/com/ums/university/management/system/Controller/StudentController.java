package com.ums.university.management.system.Controller;


import com.ums.university.management.system.DTO.StudentDTO;
import com.ums.university.management.system.Entity.Student;
import com.ums.university.management.system.Error.StudentAlreadyExists;
import com.ums.university.management.system.Error.StudentNotFound;
import com.ums.university.management.system.Service.DAO.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/addStudent")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO studentDto) throws StudentAlreadyExists {
        Student student = studentService.addStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/getStudentByEmailId/{emailId}")
    public ResponseEntity<Student> getStudentByEmailId(@PathVariable("emailId") String emailId){
        Student student = studentService.getStudent(emailId);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam("page") int pageNumber,@RequestParam("size") int pageSize,@RequestParam("sortBy") String sortBy){
        List<Student> students = studentService.getAllStudents(pageNumber,pageSize,sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }
    @PutMapping("/updateStudent/{studentId}")
    @PreAuthorize("hasAnyAuthority('Admin','Normal')")
    public ResponseEntity<Student> updateStudent(@PathVariable("studentId") Long studentId,@RequestBody StudentDTO studentDTO) throws StudentNotFound {
        Student student = studentService.updateStudent(studentId,studentDTO);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PatchMapping("/updateStudentPhone/{studentId}")
    @PreAuthorize("hasAnyAuthority('Admin','Normal')")
    public ResponseEntity<Student> updateStudentPhone(@PathVariable("studentId") Long studentId,@RequestParam("phone") String phone) throws StudentNotFound {
        Student student = studentService.updateStudentPhone(studentId, phone);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<String> deleteStudentById(@PathVariable() Long studentId) throws StudentNotFound {
        studentService.deleteStudentByStudentId(studentId);
        return ResponseEntity.status(HttpStatus.OK).body("Student with studentId: " + studentId + " has been deleted successfully");
    }

    @DeleteMapping("/deleteStudentByEmailId/{emailId}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<String> deleteStudentByEmailId(@PathVariable() String emailId) throws StudentNotFound {
        studentService.deleteStudentByEmailId(emailId);
        return ResponseEntity.status(HttpStatus.OK).body("Student with emailId: " + emailId + " has been deleted successfully");
    }
}
