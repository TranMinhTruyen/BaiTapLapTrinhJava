package com.example.common.response;

import java.math.BigDecimal;

public class SanhResponse {

    private int id;
    private String tenSanh;
    private BigDecimal giaTien;
    private int soBan;
    private String hinhAnh;

    public SanhResponse(int id, String tenSanh, BigDecimal giaTien, int soBan, String hinhAnh) {
        this.id = id;
        this.tenSanh = tenSanh;
        this.giaTien = giaTien;
        this.soBan = soBan;
        this.hinhAnh = hinhAnh;
    }

    public SanhResponse(){}

    public BigDecimal getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(BigDecimal giaTien) {
        this.giaTien = giaTien;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSanh() {
        return tenSanh;
    }

    public void setTenSanh(String tenSanh) {
        this.tenSanh = tenSanh;
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }
}
