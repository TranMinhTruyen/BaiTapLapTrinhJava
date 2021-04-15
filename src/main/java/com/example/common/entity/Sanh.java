package com.example.common.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "sanh")
public class Sanh implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TEN")
    private String ten;

    @JsonProperty("gia_tien")
    @Column(name = "GIATIEN")
    private BigDecimal giaTien;

    @JsonProperty("tong_so_ban")
    @Column(name = "TONG_SO_BAN")
    private int tongSoBan;

    @JsonProperty("hinh_anh")
    @Column(name = "HINH_ANH")
    private String hinhAnh;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="sanh")
    private List<Tiec> tiec;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public BigDecimal getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(BigDecimal giaTien) {
        this.giaTien = giaTien;
    }

    public int getTongSoBan() {
        return tongSoBan;
    }

    public void setTongSoBan(int tongSoBan) {
        this.tongSoBan = tongSoBan;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public List<Tiec> getTiec() {
        return tiec;
    }

    public void setTiec(List<Tiec> tiec) {
        this.tiec = tiec;
    }
}
