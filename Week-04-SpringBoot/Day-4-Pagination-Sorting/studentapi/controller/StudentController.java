package com.pratham.studentapi.controller;

import com.pratham.studentapi.dto.StudentDTO;
import com.pratham.studentapi.model.Student;
import com.pratham.studentapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudents(Pageable pageable) {
        return ResponseEntity.ok(studentService.getStudents(pageable));
    }

    // GET student by roll
    @GetMapping("/{roll}")
    public ResponseEntity<Student> getStudent(@PathVariable int roll) {
        return ResponseEntity.ok(studentService.getStudentByRoll(roll));
    }

    // POST add student (Using DTO - Clean Architecture)
    @PostMapping
    public ResponseEntity<String> addStudent(@Valid @RequestBody StudentDTO dto) {

        Student student = new Student(
                dto.getRoll(),
                dto.getName(),
                dto.getMarks()
        );

        studentService.addStudent(student);
        return ResponseEntity.ok("Student saved successfully");
    }

    // PUT update student
    @PutMapping("/{roll}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable int roll,
            @RequestBody Student student) {

        return ResponseEntity.ok(studentService.updateStudent(roll, student));
    }
}
