package com.example.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "HINH_ANH")
    private byte[] hinhAnh;

    @JsonIgnore
    @OneToMany(mappedBy="khachHang")
    private Set<Tiec> tiecList = new HashSet<>();

    @JsonIgnore
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


    public PhanHoi getPhanHoi() {
        return phanHoi;
    }

    public void setPhanHoi(PhanHoi phanHoi) {
        this.phanHoi = phanHoi;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public Set<Tiec> getTiecList() {
        return tiecList;
    }

    public void setTiecList(Set<Tiec> tiecList) {
        this.tiecList = tiecList;
    }
}
