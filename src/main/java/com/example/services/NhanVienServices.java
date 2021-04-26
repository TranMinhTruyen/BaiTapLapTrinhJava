package com.example.services;

import com.example.common.request.LoginRequest;
import com.example.common.request.NhanVienRequest;
import com.example.common.response.NhanVienResponse;

public interface NhanVienServices {
    NhanVienRequest createNhanVien(NhanVienRequest nhanVien);
    Object getAllNhanVien(int page, int size);
    Object getNhanVienByKeyword(int page, int size, String keyword);
    NhanVienResponse getNhanVienByTaiKhoanMatKhau(LoginRequest loginRequest);
    NhanVienRequest updateNhanVienById (int id, NhanVienRequest nhanVien);
    boolean deleteNhanVienById (int id);
}
