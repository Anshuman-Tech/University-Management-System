package com.ums.university.management.system.Service.Impl;

import com.ums.university.management.system.DTO.StudentDTO;
import com.ums.university.management.system.Entity.Guardian;
import com.ums.university.management.system.Entity.Student;
import com.ums.university.management.system.Error.StudentAlreadyExists;
import com.ums.university.management.system.Error.StudentNotFound;
import com.ums.university.management.system.Repository.StudentRepository;
import com.ums.university.management.system.Service.DAO.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.PageFormat;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents(int pageNumber,int pageSize,String sortBy) {
        Sort sort = Sort.by(sortBy);
//        Sort sort = Sort.by(sortBy).descending(); //For sorting in descending order
        Pageable pageable = PageRequest.of(pageNumber,pageSize, sort);
        Page<Student> page = studentRepository.findAll(pageable);
        List<Student> students = page.getContent();
        return students;
    }

    @Override
    public Student getStudent(String emailId) {
        return studentRepository.findByEmailId(emailId);
    }

    @Override
    public Student addStudent(StudentDTO studentDto) throws StudentAlreadyExists {
        Student existingStudent = studentRepository.findByEmailId(studentDto.getEmailId());
        if(existingStudent!=null){
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

    @Override
    public Student updateStudent(Long studentId, StudentDTO studentDTO) throws StudentNotFound {
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if(!existingStudent.isPresent()){
            throw new StudentNotFound("Student not found");
        }
        if(studentDTO.getEmailId()!=null){
            existingStudent.get().setEmailId(studentDTO.getEmailId());
        }
        if(studentDTO.getFirstName()!=null){
            existingStudent.get().setFirstName(studentDTO.getFirstName());
        }
        if(studentDTO.getLastName()!=null){
            existingStudent.get().setLastname(studentDTO.getLastName());
        }
        if(studentDTO.getDob()!=null){
            existingStudent.get().setDob(studentDTO.getDob());
        }
        if(studentDTO.getPhone()!=null){
            existingStudent.get().setPhone(studentDTO.getPhone());
        }

        if(studentDTO.getGuardianName()!=null || studentDTO.getGuardianPhone()!=null){
            Guardian guardian = new Guardian();
            if(studentDTO.getGuardianName()!=null){
                guardian.setName(studentDTO.getGuardianName());
            }
            if(studentDTO.getGuardianPhone()!=null){
                guardian.setPhone(studentDTO.getPhone());
            }
            existingStudent.get().setGuardian(guardian);
        }
        return studentRepository.save(existingStudent.get());
    }

    @Override
    public Student updateStudentPhone(Long studentId, String phone) throws StudentNotFound{
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if(!existingStudent.isPresent()){
            throw new StudentNotFound("Student with studentId: " + studentId + " not found");
        }

        Student student = existingStudent.get();
        student.setPhone(phone);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentByStudentId(Long studentId) throws StudentNotFound {
        Optional<Student> existingStudent = studentRepository.findById(studentId);
        if(!existingStudent.isPresent()){
            throw new StudentNotFound("Student not found");
        }
        studentRepository.deleteById(studentId);
    }

    @Override
    public void deleteStudentByEmailId(String emailId) throws StudentNotFound {
        Student existingStudent = studentRepository.findByEmailId(emailId);
        if(existingStudent==null){
            throw new StudentNotFound("Student not found");
        }
        studentRepository.delete(existingStudent);
    }
}
