package com.example.common.response;

public class TiecResponse {
    private int id;
    private String thoiGian;
    private String ngayToChuc;
    private String loai;
    private String sanh;
    private String khachHang;
    private String trangThai;
    private String caLamViec;
    private String menu;

    public TiecResponse() {
    }

    public TiecResponse(int id, String thoiGian, String ngayToChuc, String loai, String sanh, String khachHang, String trangThai, String caLamViec, String menu) {
        this.id = id;
        this.thoiGian = thoiGian;
        this.ngayToChuc = ngayToChuc;
        this.loai = loai;
        this.sanh = sanh;
        this.khachHang = khachHang;
        this.trangThai = trangThai;
        this.caLamViec = caLamViec;
        this.menu = menu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(String ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getSanh() {
        return sanh;
    }

    public void setSanh(String sanh) {
        this.sanh = sanh;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(String caLamViec) {
        this.caLamViec = caLamViec;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
