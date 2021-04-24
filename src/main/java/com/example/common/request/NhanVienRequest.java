package com.example.common.request;

import java.sql.Date;

public class NhanVienRequest {
    private int id;
    private String taiKhoan;
    private String matKhau;
    private String role;
    private String ho;
    private String ten;
    private Date ngaySinh;
    private String cmnd;
    private int caLamViec;
    private byte[] hinhAnh;

    public NhanVienRequest() {
    }

    public NhanVienRequest(int id, String taiKhoan, String matKhau, String role, String ho, String ten, Date ngaySinh, String cmnd, byte[] hinhAnh, int caLamViec) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.role = role;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.hinhAnh = hinhAnh;
        this.caLamViec = caLamViec;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(int caLamViec) {
        this.caLamViec = caLamViec;
    }
}
