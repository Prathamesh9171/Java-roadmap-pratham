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
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    // Update student
    public Student updateStudent(int roll, Student updatedStudent) {
        Student student = repository.findById(roll)
                .orElseThrow(() -> new RuntimeException("Student not found with roll: " + roll));

        student.setName(updatedStudent.getName());
        student.setMarks(updatedStudent.getMarks());

        return repository.save(student);
    }

    // Delete student
    public void deleteStudent(int roll) {
        if (!repository.existsById(roll)) {
            throw new RuntimeException("Student not found with roll: " + roll);
        }
        repository.deleteById(roll);
    }
    public Page<Student> getStudents(Pageable pageable){
        return repository.findAll(pageable);
    }

}
