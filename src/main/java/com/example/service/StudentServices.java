package com.example.service;

import com.example.repository.StudentRepository;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    /*
    Thêm sinh viên
     */
    public Student addStudent(Student student){
       return studentRepository.save(student);
    }

    /*
    Lấy tất cả sinh viên
     */
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    /*
    Lấy sinh viên theo mssv
     */
    public Student getStudentById(long id) {
        return studentRepository.findStudentByMssv(id);
    }

    /*
    Cập nhật sinh viên theo mssv
     */
    public Student updateStudent(long id, Student student){
        Student dataStd = getStudentById(id);
        if (dataStd != null) {
            dataStd.setName(student.getName());
            dataStd.setBirthday(student.getBirthday());
            dataStd.setGender(student.getGender());
            studentRepository.save(dataStd);
            return dataStd;
        }
        else {
            return null;
        }
    }

    /*
    Xóa sinh viên theo mssv
     */
    public boolean deleteStudentById(long id) {
        if (getStudentById(id) != null){
            studentRepository.deleteById(id);
            return true;
        }
        else
            return false;
    }
}
