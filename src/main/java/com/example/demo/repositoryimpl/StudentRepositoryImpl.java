package com.example.demo.repositoryimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentRowMapper;
import com.example.demo.repository.StudentRepository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getAllDetails() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    @Override
    public Student getDetails(Long studentId) {
        String sql = "SELECT * FROM students WHERE student_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{studentId}, new StudentRowMapper());
    }

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (student_id, student_name, student_address) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, student.getStudentId(), student.getStudentName(), student.getStudentAddress());
    }
}

