package com.example.common.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "danhsachnhanvien")
public class DanhSachNhanVien implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "TIEC_ID")
    private Tiec tiec;

    @ManyToOne()
    @JoinColumn(name = "NHANVIEN_ID")
    private NhanVien nhanVien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTiec() {
        return tiec.getId();
    }

    public void setTiec(int id) {
        this.tiec.setId(id);
    }

    public int getNhanVien() {
        return nhanVien.getId();
    }

    public void setNhanVien(int id) {
        this.nhanVien.setId(id);
    }
}
