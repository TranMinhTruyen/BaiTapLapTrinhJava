package com.example.controller;

import com.example.service.StudentServices;
import com.example.entity.Student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Student")
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
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createStudent", consumes = {"application/json"})
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
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping("getAllStudent")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> listStudent = studentService.getAllStudent();
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }


    /*
    Lấy sinh viên theo mssv
     */
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getStudentById/id={id}")
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
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateStudent/id={id}", consumes = {"application/json"})
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
    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteByStudent/id={id}")
    public ResponseEntity<Boolean> deleteStudenById(@PathVariable("id") long id){
        Boolean res = studentService.deleteStudentById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
