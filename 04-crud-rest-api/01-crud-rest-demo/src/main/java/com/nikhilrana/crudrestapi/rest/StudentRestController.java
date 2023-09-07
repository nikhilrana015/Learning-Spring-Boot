package com.nikhilrana.crudrestapi.rest;

import com.nikhilrana.crudrestapi.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentRestController {

    private List<Student>allStudents;

    @PostConstruct
    public void loadData() {

        allStudents = new ArrayList<>();

        allStudents.add(new Student("nikhil", "rana", "nikhil@google.com"));
        allStudents.add(new Student("niket", "sahai", "niket@google.com"));
        allStudents.add(new Student("ajay", "sharma", "ajay@google.com"));
    }

    @GetMapping("/students")
    List<Student> getStudents() {
        return allStudents;
    }

    @GetMapping("/students/{studentId}")
    Student getStudentById(@PathVariable int studentId) {

        if(studentId >= allStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("student id not found - " + studentId);
        }

        return allStudents.get(studentId);
    }
}
