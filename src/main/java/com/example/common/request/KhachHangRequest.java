package com.example.common.request;

import com.example.common.response.KhachHangResponse;

public class KhachHangRequest extends KhachHangResponse {
    private String taiKhoan;
    private String matKhau;


    public KhachHangRequest(int id, String ho, String ten, String ngaySinh, String hinhAnh, String taiKhoan, String matKhau) {
        super(id, ho, ten, ngaySinh, hinhAnh);
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
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
}
