package com.example.services;

import com.example.common.request.MenuThucAnRequest;

public interface MenuThucAnServices {
    MenuThucAnRequest create(MenuThucAnRequest menuThucAns);
    Object getListThucAnByMenuId(long idMenu);
    boolean deleteByIdThucAn(int idThucAn);
    boolean deleteByIdMenu(int idMenu);
    boolean deleteThucAnByIdMenu(long idMenu, int idThucAn);
}
