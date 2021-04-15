package com.example.common.wrapper;

public class MenuWrapper {
    private Long id;
    private String tenMenu;

    public MenuWrapper(Long id, String tenMenu) {
        this.id = id;
        this.tenMenu = tenMenu;
    }

    public MenuWrapper(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenMenu() {
        return tenMenu;
    }

    public void setTenMenu(String tenMenu) {
        this.tenMenu = tenMenu;
    }
}
