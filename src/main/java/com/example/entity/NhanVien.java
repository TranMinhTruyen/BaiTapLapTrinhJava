package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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

    @Column(name = "HO")
    private String ho;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "NGAY_SINH")
    private Date ngaySinh;

    @Column(name = "CMND")
    private String cmnd;

    @Column(name = "CHUC_VU")
    private String chucVu;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy="nhanViens")
    private List<Tiec> tiec;
}
