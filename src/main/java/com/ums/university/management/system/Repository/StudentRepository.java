package com.ums.university.management.system.Repository;

import com.ums.university.management.system.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByEmailId(String emailId);

}
