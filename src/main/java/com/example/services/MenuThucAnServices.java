package com.example.services;

import com.example.common.entity.MenuThucAn;

public interface MenuThucAnServices {
    MenuThucAn create(MenuThucAn menuThucAns);
    Object getListThucAnByMenuId(long idMenu);
    boolean deleteByIdThucAn(int idThucAn);
    boolean deleteByIdMenu(int idMenu);
    boolean deleteThucAnByIdMenu(long idMenu, int idThucAn);
}
