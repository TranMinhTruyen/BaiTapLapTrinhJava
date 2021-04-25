package com.example.common.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "nhanvien")
public class NhanVien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TAI_KHOAN")
    private String taiKhoan;

    @Column(name = "MAT_KHAU")
    private String matKhau;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "HO")
    private String ho;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "NGAY_SINH")
    private Date ngaySinh;

    @Column(name = "CMND")
    private String cmnd;

    @Column(name = "HINH_ANH")
    private String hinhAnh;

    @ManyToOne()
    @JoinColumn(name = "ID_CALAMVIEC")
    private CaLamViec caLamViec;

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

    public void setCaLamViec(CaLamViec caLamViec) {
        this.caLamViec = caLamViec;
    }

    public int getCaLamViec() {
        return caLamViec.getId();
    }

    public void setCaLamViec(int caLamViec) {
        CaLamViec addId = new CaLamViec();
        addId.setId(caLamViec);
        this.caLamViec = addId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
