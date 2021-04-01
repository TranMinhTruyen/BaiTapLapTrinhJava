package com.example.common.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import java.io.Serializable;
import java.math.BigDecimal;


@JsonPropertyOrder({
        "id",
        "ten",
        "giaTien",
        "soLuong",
        "hinhAnh"
})
public class MenuWrapper implements Serializable {

    @JsonProperty("idThucAn")
    private int id;
    private String ten;
    private BigDecimal giaTien;
    private String hinhAnh;
    private int soLuong;

    public MenuWrapper(int id, String ten, BigDecimal giaTien, String hinhAnh, int soLuong) {
        this.id = id;
        this.ten = ten;
        this.giaTien = giaTien;
        this.hinhAnh = hinhAnh;
        this.soLuong = soLuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
