package com.example.service;

import com.example.entity.Khoa;
import com.example.repository.KhoaReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoaServices {
    @Autowired
    private KhoaReponsitory khoaReponsitory;

    /*
    Thêm khoa
     */
    public Khoa addKhoa(Khoa khoa){
        return khoaReponsitory.save(khoa);
    }

    /*
    Lấy tất cả khoa
     */
    public List<Khoa> getAllKhoa() {
        return khoaReponsitory.findAll();
    }

    /*
    Lấy khoa theo id
     */
    public Khoa getKhoaById(int id) {
        return khoaReponsitory.findKhoaById(id);
    }

    /*
    Cập nhật khoa theo id
    */
    public Khoa updateKhoa(int id, Khoa khoa){
        Khoa dataKhoa = getKhoaById(id);
        if (dataKhoa != null) {
            dataKhoa.setName(khoa.getName());
            khoaReponsitory.save(dataKhoa);
            return dataKhoa;
        }
        else {
            return null;
        }
    }

    /*
    Xóa khoa theo id
     */
    public boolean deleteKhoaById(int id) {
        if (getKhoaById(id) != null){
            khoaReponsitory.deleteById(id);
            return true;
        }
        else
            return false;
    }
}
