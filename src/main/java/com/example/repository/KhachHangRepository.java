package com.example.repository;

import com.example.common.entity.KhachHang;

import java.util.List;

public interface KhachHangRepository {
    KhachHang createKhachHang(KhachHang khachHang);
    List getAllKhachHang();
    List getKhachHangByKeyword(String keyword);
    KhachHang getKhachHangByTaiKhoanMatKhau(String taiKhoan, String matKhau);
    KhachHang getKhachHangById(int id);
    boolean KhachHangIsExist(String taiKhoan);
    void updateKhachHangById (int id, KhachHang khachHang);
    void deleteKhachHangById (int id);
}
