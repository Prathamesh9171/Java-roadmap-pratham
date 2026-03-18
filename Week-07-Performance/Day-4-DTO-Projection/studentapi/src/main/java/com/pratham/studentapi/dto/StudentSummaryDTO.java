package com.pratham.studentapi.dto;

public class StudentSummaryDTO {

    private String name;
    private double marks;

    public StudentSummaryDTO(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }
}
