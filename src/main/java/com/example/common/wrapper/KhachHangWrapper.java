package com.example.common.wrapper;

import java.io.Serializable;


public class KhachHangWrapper implements Serializable {

    private int id;
    private String tenKhachHang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }
}
