package com.example.test.controller;

import com.example.test.entity.Student;
import com.example.test.service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class StudentController {
    @Autowired
    private StudentServices studentService;

    @GetMapping("student/all")
    public ResponseEntity<List<Student>> getAll(){
        List<Student> listStudent = studentService.getAllStudent();
        return new ResponseEntity<List<Student>>(listStudent, HttpStatus.OK);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") long id){
        Student std = studentService.getStudent(id);
        return new ResponseEntity<>(std, HttpStatus.OK);
    }
}
