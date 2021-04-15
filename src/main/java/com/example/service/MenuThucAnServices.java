package com.example.service;

import com.example.common.entity.MenuThucAn;

import java.util.List;

public interface MenuThucAnServices {
    MenuThucAn create(MenuThucAn menuThucAns);
    List getMenuThucAnByMenuId(long idMenu);
    boolean deleteByIdThucAn(int idThucAn);
    boolean deleteByIdMenu(int idMenu);
    boolean deleteThucAnByIdMenu(long idMenu, int idThucAn);
}
