package com.pratham.studentapi.controller;

import com.pratham.studentapi.model.Student;
import com.pratham.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // GET student by roll
    @GetMapping("/{roll}")
    public ResponseEntity<Student> getStudent(@PathVariable int roll) {
        return ResponseEntity.ok(studentService.getStudentByRoll(roll));
    }

    // POST add student
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    // PUT update student
    @PutMapping("/{roll}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable int roll,
            @RequestBody Student student) {

        return ResponseEntity.ok(studentService.updateStudent(roll, student));
    }

    // DELETE student
    @DeleteMapping("/{roll}")
    public ResponseEntity<String> deleteStudent(@PathVariable int roll) {
        studentService.deleteStudent(roll);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
