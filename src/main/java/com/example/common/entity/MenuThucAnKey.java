package com.example.common.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MenuThucAnKey implements Serializable {

    @Column(name = "thucan_id")
    private Integer thucAnId;

    @Column(name = "menu_id")
    private Long menuId;

    public Integer getThucAnId() {
        return thucAnId;
    }

    public void setThucAnId(Integer thucAnId) {
        this.thucAnId = thucAnId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
