package com.pratham.studentapi.dto;

import jakarta.validation.constraints.*;

public class StudentDTO {

    @NotNull(message = "Roll number is required")
    private Integer roll;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 0, message = "Marks must be >= 0")
    @Max(value = 100, message = "Marks must be <= 100")
    private double marks;

    public Integer getRoll() { return roll; }
    public void setRoll(Integer roll) { this.roll = roll; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }
}