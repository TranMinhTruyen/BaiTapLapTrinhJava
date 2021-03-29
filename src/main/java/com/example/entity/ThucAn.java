package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "thucan")
public class ThucAn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TEN")
    private String ten;

    @Column(name = "GIA_TIEN")
    private BigDecimal giaTien;

    @OneToMany(mappedBy = "thucAn")
    private List<Menu> menu;

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

    @JsonIgnore
    public List<Menu> getMenu() {
        return menu;
    }

    @JsonIgnore
    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
}
