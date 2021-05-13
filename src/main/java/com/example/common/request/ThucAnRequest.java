package com.example.common.request;

import com.example.common.response.ThucAnResponse;

public class ThucAnRequest extends ThucAnResponse {
    public ThucAnRequest(Integer id, String ten, String loai, String hinhAnh) {
        super(id, ten, loai, hinhAnh);
    }

    public ThucAnRequest() {
    }
}
