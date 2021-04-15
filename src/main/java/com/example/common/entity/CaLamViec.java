package com.example.common.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "calamviec")
public class CaLamViec implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CA_LAM")
    private String caLam;

    @OneToMany(mappedBy = "caLamViec", fetch = FetchType.LAZY)
    private List<Tiec> tiec;

    @OneToMany(mappedBy = "caLamViec", fetch = FetchType.LAZY)
    private List<NhanVien> nhanVien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaLam() {
        return caLam;
    }

    public void setCaLam(String caLam) {
        this.caLam = caLam;
    }

    public List<Tiec> getTiec() {
        return tiec;
    }

    public void setTiec(List<Tiec> tiec) {
        this.tiec = tiec;
    }

    public List<NhanVien> getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(List<NhanVien> nhanVien) {
        this.nhanVien = nhanVien;
    }
}
