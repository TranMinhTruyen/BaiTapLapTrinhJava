package com.example.service;

import com.example.repository.StudentRepository;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent(String name) {
        return studentRepository.findAllByKhoa_Name(name);
    }

//    public Optional<Student> getStudentById(long id) {
//        return studentRepository.findById(id);
//    }
//
//    public boolean deleteStudentById(long id) {
//        studentRepository.deleteById(id);
//        return true;
//    }
}
