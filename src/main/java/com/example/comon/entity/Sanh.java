package com.example.comon.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "sanh")
public class Sanh implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TEN")
    private String ten;

    @JsonProperty("giatien")
    @Column(name = "GIATIEN")
    private BigDecimal giaTien;

    @JsonProperty("sochongoi")
    @Column(name = "SOCHONGOI")
    private int soChoNgoi;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,mappedBy="sanh")
    private Tiec tiec;

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

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public Tiec getTiec() {
        return tiec;
    }

    public void setTiec(Tiec tiec) {
        this.tiec = tiec;
    }
}
