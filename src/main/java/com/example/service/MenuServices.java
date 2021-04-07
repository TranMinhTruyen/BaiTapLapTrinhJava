package com.example.service;

import com.example.common.entity.Menu;

import java.util.List;

public interface MenuServices {
    List getAllMenu();
    Object getMenuCuaTiec(int page, int size, int keyword);
    Menu createMenu(Menu menu);
    Menu updateSoLuong(int idTiec, int idThucAn, Menu menu);
    Boolean deleteThucAn(int idTiec, int idThucAn);
    Boolean deleteMenu(int idTiec);
}
