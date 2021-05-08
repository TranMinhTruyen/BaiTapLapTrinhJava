package com.example.repository;

import com.example.common.entity.NhanVien;

import java.util.List;

public interface NhanVienRepository {
    NhanVien createNhanVien(NhanVien nhanVien);
    List getAllNhanVien();
    List getNhanVienByKeyword(String keyword);
    NhanVien getNhanVienByTaiKhoanMatKhau(String taiKhoan, String matKhau);
    NhanVien getNhanVienById(int id);
    boolean NhanVienIsExist(String taiKhoan);
    void updateNhanVienById (int id, NhanVien nhanVien);
    void deleteNhanVienById (int id);
}
