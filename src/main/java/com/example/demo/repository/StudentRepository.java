package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentRepository {

	List<Student> getAllDetails();
    Student getDetails(Long studentId);
    void addStudent(Student student);
	
}
