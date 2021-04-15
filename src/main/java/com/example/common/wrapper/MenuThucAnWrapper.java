package com.example.common.wrapper;

public class MenuThucAnWrapper {
    private Long idMenu;
    private Integer idThucAn;

    public MenuThucAnWrapper(Long idMenu, Integer idThucAn) {
        this.idMenu = idMenu;
        this.idThucAn = idThucAn;
    }

    public MenuThucAnWrapper(){}

    public long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdThucAn() {
        return idThucAn;
    }

    public void setIdThucAn(Integer idThucAn) {
        this.idThucAn = idThucAn;
    }
}
