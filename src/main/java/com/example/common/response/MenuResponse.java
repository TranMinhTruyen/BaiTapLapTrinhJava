package com.example.common.response;

public class MenuResponse {
    private Long id;
    private String tenMenu;

    public MenuResponse(Long id, String tenMenu) {
        this.id = id;
        this.tenMenu = tenMenu;
    }

    public MenuResponse(){
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
