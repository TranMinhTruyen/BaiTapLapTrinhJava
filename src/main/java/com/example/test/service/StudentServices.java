package com.example.test.service;

import com.example.test.entity.Student;
import com.example.test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    public Student getStudent(long id) {
        return studentRepository.getOne(id);
    }
}
