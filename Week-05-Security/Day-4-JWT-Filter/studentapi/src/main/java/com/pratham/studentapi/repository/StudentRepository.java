package com.pratham.studentapi.repository;

import com.pratham.studentapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByName(String name);

    List<Student> findByMarksGreaterThan(double marks);

    List<Student> findByNameContainingIgnoreCase(String name);
}
