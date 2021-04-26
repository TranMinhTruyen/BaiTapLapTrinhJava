package com.example.common.response;

public class NhanVienResponse {
    private String role;
    private String ho;
    private String ten;
    private String ngaySinh;
    private String cmnd;
    private int caLamViec;
    private String hinhAnh;

    public NhanVienResponse() {
    }

    public NhanVienResponse(String role, String ho, String ten, String ngaySinh, String cmnd, int caLamViec, String hinhAnh) {
        this.role = role;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.caLamViec = caLamViec;
        this.hinhAnh = hinhAnh;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public int getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(int caLamViec) {
        this.caLamViec = caLamViec;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
