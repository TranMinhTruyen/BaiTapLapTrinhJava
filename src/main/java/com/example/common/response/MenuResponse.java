package com.example.common.response;

import com.example.common.entity.ThucAn;

import java.util.List;

public class MenuResponse {
    private long id;
    private String tenMenu;
    protected List<ThucAn> thucAnList;

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

    public List<ThucAn> getThucAnList() {
        return thucAnList;
    }

    public void setThucAnList(List<ThucAn> thucAnList) {
        this.thucAnList = thucAnList;
    }
}
