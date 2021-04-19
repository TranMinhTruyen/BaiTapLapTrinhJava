package com.example.common.response;

import java.math.BigDecimal;

public class ThucAnResponse {
    private Integer id;
    private String ten;
    private BigDecimal giaTien;
    private String hinhAnh;

    public ThucAnResponse(Integer id, String ten, BigDecimal giaTien, String hinhAnh) {
        this.id = id;
        this.ten = ten;
        this.giaTien = giaTien;
        this.hinhAnh = hinhAnh;
    }

    public ThucAnResponse(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

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
}
