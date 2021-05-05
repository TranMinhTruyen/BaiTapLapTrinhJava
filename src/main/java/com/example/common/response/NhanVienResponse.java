package com.example.common.response;

public class NhanVienResponse {
    private String role;
    private String ho;
    private String ten;
    private String ngaySinh;
    private String cmnd;
    private String caLamViec;
    private String hinhAnh;

    public NhanVienResponse() {
    }

    public NhanVienResponse(String role, String ho, String ten, String ngaySinh, String cmnd, String caLamViec, String hinhAnh) {
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

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(String caLamViec) {
        this.caLamViec = caLamViec;
    }
}
