package com.example.common.request;

import java.sql.Date;

public class KhachHangRequest {
    private int id;
    private String taiKhoan;
    private String matKhau;
    private String ho;
    private String ten;
    private Date ngaySinh;
//    private byte[] hinhAnh;

    public KhachHangRequest() {
    }

    public KhachHangRequest(int id, String taiKhoan, String matKhau, String ho, String ten, Date ngaySinh) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
}
