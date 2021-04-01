package com.example.common.entity;

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

    public int getTiec() {
        return tiec.getId();
    }

    public void setTiec(int id) {
        this.tiec.setId(id);
    }

    public int getThucAn() {
        return thucAn.getId();
    }

    public void setThucAn(int id) {
        this.thucAn.setId(id);
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
