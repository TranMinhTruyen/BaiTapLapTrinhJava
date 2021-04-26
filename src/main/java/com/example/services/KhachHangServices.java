package com.example.services;

import com.example.common.request.KhachHangRequest;
import com.example.common.request.LoginRequest;
import com.example.common.response.KhachHangResponse;

public interface KhachHangServices {
    KhachHangRequest createKhachHang(KhachHangRequest khachHang);
    Object getAllKhachHang(int page, int size);
    Object getKhachHangByKeyword(int page, int size, String keyword);
    KhachHangResponse getKhachHangByTaiKhoanMatKhau(LoginRequest loginRequest);
    KhachHangRequest updateKhachHangById (int id, KhachHangRequest khachHang);
    boolean deleteKhachHangById (int id);
}
