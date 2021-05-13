package com.example.common.request;

import com.example.common.response.MenuResponse;

import java.math.BigDecimal;

public class MenuRequest extends MenuResponse {
    public MenuRequest(Long id, String tenMenu, BigDecimal giaTien) {
        super(id, tenMenu, giaTien);
    }
}
