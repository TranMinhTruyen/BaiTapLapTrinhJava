package com.example.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TEN_MENU")
    private String tenMenu;

    @JsonIgnore
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<Tiec> tiec;

    @JsonIgnore
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY)
    private List<MenuThucAn> menuThucAns = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenMenu() {
        return tenMenu;
    }

    public void setTenMenu(String tenMenu) {
        this.tenMenu = tenMenu;
    }

    public List<Tiec> getTiec() {
        return tiec;
    }

    public void setTiec(List<Tiec> tiec) {
        this.tiec = tiec;
    }

    public List<MenuThucAn> getThucAns() {
        return menuThucAns;
    }

    public void setThucAns(List<MenuThucAn> menuThucAns) {
        this.menuThucAns = menuThucAns;
    }
}
