package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @Column(name = "ID")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "TIEC_ID")
    private Tiec tiec;

    @ManyToOne()
    @JoinColumn(name = "THUC_AN_ID")
    private ThucAn thucAn;

    @Column(name = "SOLUONG")
    private int soLuong;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public ThucAn getThucAn() {
        return thucAn;
    }

    @JsonIgnore
    public void setThucAn(ThucAn thucAn) {
        this.thucAn = thucAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
