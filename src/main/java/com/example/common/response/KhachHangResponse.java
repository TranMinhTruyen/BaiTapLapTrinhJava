package com.example.common.response;

import java.io.Serializable;


public class KhachHangResponse implements Serializable {

    private String ho;
    private String ten;
    private String ngaySinh;
    private String hinhAnh;

    public KhachHangResponse() {
    }

    public KhachHangResponse(String ho, String ten, String ngaySinh, String hinhAnh) {
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.hinhAnh = hinhAnh;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
