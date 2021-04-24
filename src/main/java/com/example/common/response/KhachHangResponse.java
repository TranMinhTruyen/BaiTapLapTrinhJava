package com.example.common.response;

import java.io.Serializable;


public class KhachHangResponse implements Serializable {

    private int id;
    private String taiKhoan;
    private String matKhau;
    private String ho;
    private String ten;
    private String ngaySinh;
    private byte[] hinhAnh;

    public KhachHangResponse() {
    }

    public KhachHangResponse(int id, String taiKhoan, String matKhau, String ho, String ten, String ngaySinh, byte[] hinhAnh) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.hinhAnh = hinhAnh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
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

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
