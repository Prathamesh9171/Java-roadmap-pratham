package com.pratham.studentapi.repository;

import com.pratham.studentapi.dto.StudentSummaryDTO;
import com.pratham.studentapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>,
        JpaSpecificationExecutor<Student> {

    List<Student> findByName(String name);

    List<Student> findByMarksGreaterThan(double marks);

    List<Student> findByNameContainingIgnoreCase(String name);

    @Query("SELECT new com.pratham.studentapi.dto.StudentSummaryDTO(s.name, s.marks) FROM Student s")
    List<StudentSummaryDTO> findStudentSummaries();
}