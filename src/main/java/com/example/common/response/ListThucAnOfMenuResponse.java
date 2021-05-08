package com.example.common.response;

import java.util.List;

public class ListThucAnOfMenuResponse {
    private long id;
    private String tenMenu;
    protected List<Object> thucAnList;

    public ListThucAnOfMenuResponse(long id, String tenMenu, List<Object> thucAnList) {
        this.id = id;
        this.tenMenu = tenMenu;
        this.thucAnList = thucAnList;
    }

    public ListThucAnOfMenuResponse(){}

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

    public List getThucAnList() {
        return thucAnList;
    }

    public void setThucAnList(List<Object> thucAnList) {
        this.thucAnList = thucAnList;
    }
}
