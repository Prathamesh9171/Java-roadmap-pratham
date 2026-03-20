package com.pratham.studentapi.spec;

import com.pratham.studentapi.model.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {

    public static Specification<Student> hasName(String name) {
        return (root, query, cb) ->
                name == null ? null :
                        cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Student> hasMinMarks(Double marks) {
        return (root, query, cb) ->
                marks == null ? null :
                        cb.greaterThanOrEqualTo(root.get("marks"), marks);
    }
}