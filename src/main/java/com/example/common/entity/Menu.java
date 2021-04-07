package com.example.common.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIEC_ID")
    private Tiec tiec = new Tiec();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THUC_AN_ID")
    private ThucAn thucAn = new ThucAn();

    @Column(name = "SOLUONG")
    private int soLuong;

    public Menu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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
}
