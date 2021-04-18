package com.example.common.request;

import java.sql.Date;
import java.sql.Time;

public class TiecRequest {
    private int id;
    private Time thoiGian;
    private Date ngayToChuc;
    private String loai;
    private int sanh;
    private int khachHang;
    private String trangThai;
    private int caLamViec;
    private long menu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Time thoiGian) {
        this.thoiGian = thoiGian;
    }

    public Date getNgayToChuc() {
        return ngayToChuc;
    }

    public void setNgayToChuc(Date ngayToChuc) {
        this.ngayToChuc = ngayToChuc;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getSanh() {
        return sanh;
    }

    public void setSanh(int sanh) {
        this.sanh = sanh;
    }

    public int getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(int khachHang) {
        this.khachHang = khachHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getCaLamViec() {
        return caLamViec;
    }

    public void setCaLamViec(int caLamViec) {
        this.caLamViec = caLamViec;
    }

    public long getMenu() {
        return menu;
    }

    public void setMenu(long menu) {
        this.menu = menu;
    }
}
