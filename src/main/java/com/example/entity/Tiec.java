package com.example.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;
import java.util.List;


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
    @ManyToOne()
    @JoinColumn(name = "KHACH_HANG_ID", nullable = true)
    private KhachHang khachHang;

    @Column(name = "TRANGTHAI")
    private String trangThai;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy="tiec")
    private List<PhanHoi> phanHois;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "DANHSACHNHANVIEN",
            joinColumns = @JoinColumn(name = "TIEC_ID"),
            inverseJoinColumns = @JoinColumn(name = "NHANVIEN_ID")
    )
    private List<NhanVien> nhanViens;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy="tiec")
    private List<Menu> menu;

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

    public List<PhanHoi> getPhanHois() {
        return phanHois;
    }

    public void setPhanHois(List<PhanHoi> phanHois) {
        this.phanHois = phanHois;
    }

    public List<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(List<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
