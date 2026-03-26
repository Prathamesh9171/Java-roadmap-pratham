package com.pratham.studentapi.service;

import com.pratham.studentapi.model.Student;
import com.pratham.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class StudentService {

    private static final Logger log =
            LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository repository;

    // Cache list of students
    @Cacheable(value = "students")
    public Page<Student> getStudents(Pageable pageable) {

        log.info("Fetching students with pagination (DB hit)");
        return repository.findAll(pageable);
    }

    // Cache individual student
    @Cacheable(value = "student", key = "#roll")
    public Student getStudentByRoll(int roll) {

        log.info("Fetching student with roll {} (DB hit)", roll);

        return repository.findById(roll)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));
    }

    // When new student added → clear cache
    @CacheEvict(value = {"students", "student"}, allEntries = true)
    public void addStudent(Student student) {

        log.info("Adding student {}", student.getName());

        repository.save(student);
    }

    // When updating → clear cache
    @CacheEvict(value = {"students", "student"}, allEntries = true)
    public Student updateStudent(int roll, Student updatedStudent) {

        log.info("Updating student with roll {}", roll);

        Student existing = repository.findById(roll)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        existing.setName(updatedStudent.getName());
        existing.setMarks(updatedStudent.getMarks());

        return repository.save(existing);
    }

    // When deleting → clear cache
    @CacheEvict(value = {"students", "student"}, allEntries = true)
    public void deleteStudent(int roll) {

        log.info("Deleting student with roll {}", roll);

        repository.deleteById(roll);
    }

    public List<Student> searchByName(String name) {

        log.info("Searching students with name {}", name);

        return repository.findByName(name);
    }

    public List<Student> findTopStudents(double marks) {

        log.info("Fetching students with marks greater than {}", marks);

        return repository.findByMarksGreaterThan(marks);
    }

    public List<Student> searchByPartialName(String name) {

        log.info("Searching students with partial name {}", name);

        return repository.findByNameContainingIgnoreCase(name);
    }
}