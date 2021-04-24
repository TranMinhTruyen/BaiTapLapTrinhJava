package com.example.common.response;

import java.math.BigDecimal;

public class MenuResponse {
    private Long id;
    private String tenMenu;
    private BigDecimal giaTien;

    public MenuResponse(Long id, String tenMenu, BigDecimal giaTien) {
        this.id = id;
        this.tenMenu = tenMenu;
        this.giaTien = giaTien;
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

    public BigDecimal getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(BigDecimal giaTien) {
        this.giaTien = giaTien;
    }
}
