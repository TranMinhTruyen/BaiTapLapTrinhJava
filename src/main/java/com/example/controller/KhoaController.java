package com.example.controller;

import com.example.entity.Khoa;
import com.example.service.KhoaServices;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Khoa")
@RestController
@CrossOrigin("*")
@RequestMapping("api/khoa")
public class KhoaController {

    @Autowired
    private KhoaServices khoaServices;
    private String message;

    /*
    Tạo mới 1 khoa
     */
    @PostMapping("createKhoa")
    public ResponseEntity<?> createKhoa(@RequestBody Khoa khoa){
        Khoa dataKhoa = khoaServices.addKhoa(khoa);
        if (dataKhoa != null){
            return new ResponseEntity<Khoa>(dataKhoa, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
    Lấy tất cả khoa
     */
    @GetMapping("getAllKhoa")
    public ResponseEntity<List<Khoa>> getKhoatbyId(){
        List<Khoa> listKhoa = khoaServices.getAllKhoa();
        return new ResponseEntity<>(listKhoa, HttpStatus.OK);
    }

    /*
    Lấy khoa theo id
     */
    @GetMapping("getKhoaById/id={id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id){
        Khoa khoa = khoaServices.getKhoaById(id);
        if (khoa != null)
            return new ResponseEntity<>(khoa, HttpStatus.OK);
        else {
            message = "Không tìm thấy sinh viên có MSSV: " + id;
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
    }

    /*
    Cập nhật khoa theo id
     */
    @PutMapping("updateStudent/id={id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") int id, @RequestBody Khoa khoa){
        Khoa dataKhoa = khoaServices.updateKhoa(id, khoa);
        if (dataKhoa != null)
            return new ResponseEntity<>(dataKhoa, HttpStatus.OK);
        else {
            message = "Không tìm thấy sinh viên có MSSV: " + id;
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
    }

    /*
    Xóa sinh viên theo mssv
     */
    @DeleteMapping("deleteByStudent/id={id}")
    public ResponseEntity<Boolean> deleteStudenById(@PathVariable("id") int id){
        Boolean res = khoaServices.deleteKhoaById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
