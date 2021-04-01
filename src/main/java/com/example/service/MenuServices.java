package com.example.service;

import com.example.common.entity.Menu;

import java.util.List;

public interface MenuServices {
    List getAllMenu();
    List getMenuCuaTiec(int keyword);
    List createMenu(List<Menu> menus);
    Menu updateSoLuong(int idTiec, int idThucAn, Menu menu);
    Boolean deleteThucAn(int idTiec, int idThucAn);
    Boolean deleteMenu(int idTiec);
}
