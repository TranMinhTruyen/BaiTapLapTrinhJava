package com.example.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "menu_thucan")
public class MenuThucAn {

    @EmbeddedId
    private MenuThucAnKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("thucAnId")
    @JoinColumn(name = "thucan_id")
    private ThucAn thucAn;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("menuId")
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public MenuThucAnKey getId() {
        return id;
    }

    public void setId(MenuThucAnKey id) {
        this.id = id;
    }

    public int getThucAn() {
        return thucAn.getId();
    }

    public void setThucAn(int thucAn) {
        ThucAn newThucAn = new ThucAn();
        newThucAn.setId(thucAn);
        this.thucAn = newThucAn;
    }

    public long getMenu() {
        return menu.getId();
    }

    public void setMenu(long menu) {
        Menu newMenu = new Menu();
        newMenu.setId(menu);
        this.menu = newMenu;
    }
}
