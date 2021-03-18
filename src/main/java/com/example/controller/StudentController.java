package com.example.controller;

import com.example.service.StudentServices;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api")
public class StudentController {
    @Autowired
    private StudentServices studentService;

    @GetMapping("student/getAllStudent/name={name}")
    public ResponseEntity<List<Student>> getAll(@PathVariable("name") String name){
        List<Student> listStudent = studentService.getAllStudent(name);
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

//    @GetMapping("student/getStudentbyId/{id}")
//    public ResponseEntity<Optional<Student>> getStudentbyId(@PathVariable("id") long id){
//        Optional<Student> student = studentService.getStudentById(id);
//        return new ResponseEntity<>(student, HttpStatus.OK);
//    }
//
//    @DeleteMapping("student/deleteByStudent/{id}")
//    public ResponseEntity<Boolean> deleteStudenById(@PathVariable("id") long id){
//        Boolean res = studentService.deleteStudentById(id);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }
}
