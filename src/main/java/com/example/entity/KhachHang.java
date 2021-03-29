package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "khachhang")
public class KhachHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TAIKHOAN")
    private String taiKhoan;

    @Column(name = "MATKHAU")
    private String matKhau;

    @Column(name = "HO")
    private String ho;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "NGAY_SINH")
    private Date ngaySinh;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="khachHang")
    private List<Tiec> tiecList;

    @OneToOne(fetch = FetchType.LAZY, mappedBy="khachHang")
    private PhanHoi phanHoi;

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

    @JsonIgnore
    public List<Tiec> getTiecList() {
        return tiecList;
    }

    @JsonIgnore
    public void setTiecList(List<Tiec> tiecList) {
        this.tiecList = tiecList;
    }

    @JsonIgnore
    public PhanHoi getPhanHoi() {
        return phanHoi;
    }

    @JsonIgnore
    public void setPhanHoi(PhanHoi phanHoi) {
        this.phanHoi = phanHoi;
    }
}
