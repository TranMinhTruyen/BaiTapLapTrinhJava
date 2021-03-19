package com.example.controller;

import com.example.service.StudentServices;
import com.example.entity.Student;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.AbstractJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    private StudentServices studentService;
    private String message;

    /*
    Tạo mới 1 sinh viên
     */
    @PostMapping("createStudent")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        Student dataStd = studentService.addStudent(student);
        if (dataStd != null){
            return new ResponseEntity<Student>(dataStd,HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
    Lấy tất cả sinh viên
     */
    @GetMapping("getAllStudent")
    public ResponseEntity<List<Student>> getStudentbyId(){
        List<Student> listStudent = studentService.getAllStudent();
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    /*
    Lấy sinh viên theo mssv
     */
    @GetMapping("getStudentById/id={id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") long id){
        Student student = studentService.getStudentById(id);
        if (student != null)
            return new ResponseEntity<>(student, HttpStatus.OK);
        else {
            message = "Không tìm thấy sinh viên có MSSV: " + id;
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
    }

    /*
    Cập nhật sinh viên theo mssv
     */
    @PutMapping("updateStudent/id={id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") long id, @RequestBody Student student){
        Student dataStd = studentService.updateStudent(id, student);
        if (dataStd != null)
            return new ResponseEntity<>(dataStd, HttpStatus.OK);
        else {
            message = "Không tìm thấy sinh viên có MSSV: " + id;
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
    }

    /*
    Xóa sinh viên theo mssv
     */
    @DeleteMapping("deleteByStudent/id={id}")
    public ResponseEntity<Boolean> deleteStudenById(@PathVariable("id") long id){
        Boolean res = studentService.deleteStudentById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
