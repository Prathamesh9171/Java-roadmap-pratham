package com.pratham.studentapi.service;

import com.pratham.studentapi.model.Student;
import com.pratham.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Get student by roll
    public Student getStudentByRoll(int roll) {
        return repository.findById(roll)
                .orElseThrow(() -> new RuntimeException("Student not found with roll: " + roll));
    }

    // Add student
    public void addStudent(Student student) {
        repository.save(student);
    }

      // Update student
  public Student updateStudent(int roll, Student updatedStudent) {

        Student existing = repository.findById(roll)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existing.setName(updatedStudent.getName());
        existing.setMarks(updatedStudent.getMarks());

        return repository.save(existing);
    }

    public Page<Student> getStudents(Pageable pageable){
        return repository.findAll(pageable);
    }

    public List<Student> searchByName(String name) {
        return repository.findByName(name);
    }

    public List<Student> findTopStudents(double marks) {
        return repository.findByMarksGreaterThan(marks);
    }

    public List<Student> searchByPartialName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
