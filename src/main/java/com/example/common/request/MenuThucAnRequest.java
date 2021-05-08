package com.example.common.request;

public class MenuThucAnRequest {
    private int idThucAn;
    private long idMenu;

    public MenuThucAnRequest() {
    }

    public MenuThucAnRequest(int idThucAn, long idMenu) {
        this.idThucAn = idThucAn;
        this.idMenu = idMenu;
    }

    public int getIdThucAn() {
        return idThucAn;
    }

    public void setIdThucAn(int idThucAn) {
        this.idThucAn = idThucAn;
    }

    public long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(long idMenu) {
        this.idMenu = idMenu;
    }
}
