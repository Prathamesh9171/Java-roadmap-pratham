package com.pratham.studentapi.exception;

import com.pratham.studentapi.response.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Student Not Found
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException ex) {

        return ResponseEntity.status(404)
                .body(new ErrorResponse(
                        404,
                        "STUDENT_NOT_FOUND",
                        ex.getMessage()
                ));
    }

    // Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {

        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        400,
                        "VALIDATION_FAILED",
                        errors
                ));
    }

    // Generic Runtime Errors
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {

        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        400,
                        "BAD_REQUEST",
                        ex.getMessage()
                ));
    }

    // Fallback (Unknown errors)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {

        return ResponseEntity.status(500)
                .body(new ErrorResponse(
                        500,
                        "INTERNAL_SERVER_ERROR",
                        "Something went wrong"
                ));
    }
}

