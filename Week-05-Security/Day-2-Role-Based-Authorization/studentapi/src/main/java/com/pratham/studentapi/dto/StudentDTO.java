package com.pratham.studentapi.dto;

import jakarta.validation.constraints.*;

public class StudentDTO {

    @NotNull(message = "Roll number is required")
    private Integer roll;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Marks are required")
    @DecimalMin(value = "0.0", message = "Marks must be >= 0")
    @DecimalMax(value = "100.0", message = "Marks must be <= 100")
    private Double marks;

    public Integer getRoll() {
        return roll;
    }

    public void setRoll(Integer roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }
}