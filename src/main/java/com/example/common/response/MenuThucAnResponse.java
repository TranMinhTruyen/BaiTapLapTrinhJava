package com.example.common.response;

public class MenuThucAnResponse {
    private Long idMenu;
    private Integer idThucAn;

    public MenuThucAnResponse(Long idMenu, Integer idThucAn) {
        this.idMenu = idMenu;
        this.idThucAn = idThucAn;
    }

    public MenuThucAnResponse(){}

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
