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

    @OneToOne()
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

    public Tiec getTiec() {
        return tiec;
    }

    public void setTiec(Tiec tiec) {
        this.tiec = tiec;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
