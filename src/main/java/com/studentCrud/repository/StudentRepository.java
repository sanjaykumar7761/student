package com.studentCrud.repository;

import com.studentCrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{
}
