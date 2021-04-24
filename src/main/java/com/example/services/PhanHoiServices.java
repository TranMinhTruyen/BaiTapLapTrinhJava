package com.example.services;

import com.example.common.request.PhanHoiRequest;
import com.example.common.response.PhanHoiResponse;

public interface PhanHoiServices {
    Object getAllPhanHoi(int page, int size);
    PhanHoiRequest createPhanHoi(PhanHoiRequest phanHoiRequest);
    Object getPhanHoiByKeyword(int page, int size, String keyword);
    PhanHoiResponse getPhanHoiById (int idTiec, int idKhachHang);
    PhanHoiRequest updatePhanHoi(int idTiec, int idKhachHang, PhanHoiRequest phanHoiRequest);
    boolean deletePhanHoi(int idTiec, int idKhachHang);
}
