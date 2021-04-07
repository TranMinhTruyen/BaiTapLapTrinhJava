package com.example.common.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "tiec")
public class Tiec implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "THOI_GIAN_BAT_DAU")
    private Time thoiGianBatDau;

    @Column(name = "NGAY_BAT_DAU")
    private Date ngayBatDau;

    @Column(name = "LOAI")
    private String loai;

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "SANH_ID", nullable = true)
    private Sanh sanh;

    @JacksonInject
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KHACH_HANG_ID", nullable = true)
    private KhachHang khachHang;

    @Column(name = "TRANGTHAI")
    private String trangThai;

    @JsonIgnore
    @OneToMany(mappedBy="tiec")
    private Set<PhanHoi> phanHois = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy="tiec")
    private Set<DanhSachNhanVien> nhanViens = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy="tiec")
    private Set<Menu> menu = new HashSet<>();

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

    public Sanh getSanh() {
        return sanh;
    }

    public void setSanh(Sanh sanh) {
        this.sanh = sanh;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Set<PhanHoi> getPhanHois() {
        return phanHois;
    }

    public void setPhanHois(Set<PhanHoi> phanHois) {
        this.phanHois = phanHois;
    }

    public Set<DanhSachNhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(Set<DanhSachNhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    public Set<Menu> getMenu() {
        return menu;
    }

    public void setMenu(Set<Menu> menu) {
        this.menu = menu;
    }
}
