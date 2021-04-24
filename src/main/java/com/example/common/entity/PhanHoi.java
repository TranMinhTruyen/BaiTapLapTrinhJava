package com.example.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "phanhoi")
public class PhanHoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOIDUNG")
    private String noiDung;

    @ManyToOne
    @JoinColumn(name = "TIEC_ID", nullable = true)
    private Tiec tiec;

    @ManyToOne
    @JoinColumn(name = "KHACH_HANG_ID", nullable = true)
    private KhachHang khachHang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public int getTiec() {
        return tiec.getId();
    }

    public void setTiec(int tiec) {
        Tiec set = new Tiec();
        set.setId(tiec);
        this.tiec = set;
    }

    public int getKhachHang() {
        return khachHang.getId();
    }

    public void setKhachHang(int khachHang) {
        KhachHang set = new KhachHang();
        set.setId(khachHang);
        this.khachHang = set;
    }
}
