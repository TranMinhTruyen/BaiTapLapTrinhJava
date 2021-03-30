package com.example.comon.entity;

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

    public int getTiec() {
        return tiec.getId();
    }

    public void setTiec(int id) {
        this.tiec.setId(id);
    }

    public int getKhachHang() {
        return khachHang.getId();
    }

    public void setKhachHang(int id) {
        this.khachHang.setId(id);
    }
}
