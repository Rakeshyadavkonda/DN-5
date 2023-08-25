package com.example.demo.mapper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.getAllDetails();
    }

    @GetMapping("/{studentId}")
    public Student getStudentDetails(@PathVariable Long studentId) {
        return studentRepository.getDetails(studentId);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentRepository.addStudent(student);
    }
}
