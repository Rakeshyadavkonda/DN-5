package com.example.demo.mapper;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setStudentId(resultSet.getLong("student_id"));
        student.setStudentName(resultSet.getString("student_name"));
        student.setStudentAddress(resultSet.getString("student_address"));
        return student;
    }
}

