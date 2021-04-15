package com.example.common.response;

import com.example.common.entity.ThucAn;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class TiecResponse  implements Serializable {
    private int id;
    private Time thoiGianBatDau;
    private Date ngayBatDau;
    private String loai;
    private int sanh;
    private int idKhachHang;
    private String trangThai;
    private String caLamViec;
    private String tenMenu;
    private List<ThucAn> danhSachThucAn;

    public TiecResponse(int id, Time thoiGianBatDau,
                        Date ngayBatDau,
                        String loai,
                        int sanh,
                        int idKhachHang,
                        String trangThai,
                        String caLamViec, String tenMenu, List<ThucAn> danhSachThucAn) {
        this.id = id;
        this.thoiGianBatDau = thoiGianBatDau;
        this.ngayBatDau = ngayBatDau;
        this.loai = loai;
        this.sanh = sanh;
        this.idKhachHang = idKhachHang;
        this.trangThai = trangThai;
        this.caLamViec = caLamViec;
        this.tenMenu = tenMenu;
        this.danhSachThucAn = danhSachThucAn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Time thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
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

    public int getTenKhachHang() {
        return idKhachHang;
    }

    public void setTenKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
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

    public String getTenMenu() {
        return tenMenu;
    }

    public void setTenMenu(String tenMenu) {
        this.tenMenu = tenMenu;
    }

    public List<ThucAn> getDanhSachThucAn() {
        return danhSachThucAn;
    }

    public void setDanhSachThucAn(List<ThucAn> danhSachThucAn) {
        this.danhSachThucAn = danhSachThucAn;
    }
}
