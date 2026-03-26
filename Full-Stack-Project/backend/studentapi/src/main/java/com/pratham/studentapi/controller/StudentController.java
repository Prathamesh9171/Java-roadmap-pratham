package com.pratham.studentapi.controller;

import com.pratham.studentapi.dto.StudentDTO;
import com.pratham.studentapi.dto.StudentSummaryDTO;
import com.pratham.studentapi.model.Student;
import com.pratham.studentapi.response.ApiResponse;
import com.pratham.studentapi.service.StudentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@SecurityRequirement(name = "BearerAuth")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Page<Student> getAllStudents(@ParameterObject Pageable pageable) {
        return studentService.getStudents(pageable);
    }

    @GetMapping("/{roll}")
    public ResponseEntity<Student> getStudent(@PathVariable int roll) {
        return ResponseEntity.ok(studentService.getStudentByRoll(roll));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addStudent(@RequestBody StudentDTO dto) {

        Student student = new Student(
                dto.getRoll(),
                dto.getName(),
                dto.getMarks()
        );

        studentService.addStudent(student);

        return ResponseEntity.ok(
                new ApiResponse("Student saved successfully", 200)
        );
    }

    @PutMapping("/{roll}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable int roll,
            @RequestBody Student student) {

        return ResponseEntity.ok(
                studentService.updateStudent(roll, student)
        );
    }

    @DeleteMapping("/{roll}")
    public ResponseEntity<ApiResponse> deleteStudent(@PathVariable int roll) {

        studentService.deleteStudent(roll);

        return ResponseEntity.ok(
                new ApiResponse("Student deleted successfully", 200)
        );
    }

    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name) {
        return studentService.searchByName(name);
    }

    @GetMapping("/top")
    public List<Student> topStudents(@RequestParam double marks) {
        return studentService.findTopStudents(marks);
    }

    @GetMapping("/search/partial")
    public List<Student> partialSearch(@RequestParam String name) {
        return studentService.searchByPartialName(name);
    }

    @GetMapping("/summary")
    public List<StudentSummaryDTO> getStudentSummary() {
        return studentService.getStudentSummaries();
    }
}