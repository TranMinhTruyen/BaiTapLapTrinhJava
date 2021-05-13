package com.example.common.request;

import com.example.common.response.SanhResponse;

import java.math.BigDecimal;

public class SanhRequest extends SanhResponse {
    public SanhRequest(int id, String tenSanh, BigDecimal giaTien, int soBan, String hinhAnh) {
        super(id, tenSanh, giaTien, soBan, hinhAnh);
    }

    public SanhRequest() {
    }
}
