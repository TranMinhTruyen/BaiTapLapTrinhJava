package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "phanhoi")
public class PhanHoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOIDUNG")
    private String noiDung;

    @ManyToOne()
    @JoinColumn(name = "TIEC_ID", nullable = true)
    private Tiec tiec;

    @OneToOne()
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

    @JsonIgnore
    public Tiec getTiec() {
        return tiec;
    }

    @JsonIgnore
    public void setTiec(Tiec tiec) {
        this.tiec = tiec;
    }

    @JsonIgnore
    public KhachHang getKhachHang() {
        return khachHang;
    }

    @JsonIgnore
    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }
}
