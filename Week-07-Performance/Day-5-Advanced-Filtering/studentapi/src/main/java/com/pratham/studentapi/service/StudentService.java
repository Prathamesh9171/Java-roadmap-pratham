package com.pratham.studentapi.service;

import com.pratham.studentapi.dto.StudentSummaryDTO;
import com.pratham.studentapi.model.Student;
import com.pratham.studentapi.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private static final Logger log =
            LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "students")
    public Page<Student> getStudents(Pageable pageable) {
        log.info("Fetching students (DB hit)");
        return repository.findAll(pageable);
    }

    @Cacheable(value = "student", key = "#roll")
    public Student getStudentByRoll(int roll) {
        log.info("Fetching student {} (DB hit)", roll);
        return repository.findById(roll)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @CacheEvict(value = {"students", "student"}, allEntries = true)
    public void addStudent(Student student) {
        log.info("Adding student {}", student.getName());
        repository.save(student);
    }

    @CacheEvict(value = {"students", "student"}, allEntries = true)
    public Student updateStudent(int roll, Student updatedStudent) {

        log.info("Updating student {}", roll);

        Student existing = repository.findById(roll)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setName(updatedStudent.getName());
        existing.setMarks(updatedStudent.getMarks());

        return repository.save(existing);
    }

    @CacheEvict(value = {"students", "student"}, allEntries = true)
    public void deleteStudent(int roll) {
        log.info("Deleting student {}", roll);
        repository.deleteById(roll);
    }

    // Search APIs
    public List<Student> searchByName(String name) {
        return repository.findByName(name);
    }

    public List<Student> findTopStudents(double marks) {
        return repository.findByMarksGreaterThan(marks);
    }

    public List<Student> searchByPartialName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<StudentSummaryDTO> getStudentSummaries() {
        return repository.findStudentSummaries();
    }
}