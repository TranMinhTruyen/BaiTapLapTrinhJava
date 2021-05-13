package com.example.common.request;

import com.example.common.response.PhanHoiResponse;

public class PhanHoiRequest extends PhanHoiResponse {
    public PhanHoiRequest() {
    }

    public PhanHoiRequest(int id, String noiDung, int idTiec, int idKhachHang) {
        super(id, noiDung, idTiec, idKhachHang);
    }
}
