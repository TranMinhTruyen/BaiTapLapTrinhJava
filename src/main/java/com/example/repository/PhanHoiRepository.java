package com.example.repository;

import com.example.common.entity.PhanHoi;

import java.util.List;

public interface PhanHoiRepository {
    List getAllPhanHoi();
    PhanHoi createPhanHoi(PhanHoi phanHoi);
    List getPhanHoiByKeyword(String keyword);
    PhanHoi getPhanHoiById (int idTiec, int idKhachHang);
    void updatePhanHoi(int idTiec, int idKhachHang, PhanHoi phanHoi);
    void deletePhanHoi(int idTiec, int idKhachHang);
}
