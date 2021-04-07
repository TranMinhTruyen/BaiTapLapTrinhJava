package com.example.repository;

import com.example.common.entity.Menu;

import java.util.List;

public interface MenuRepository {
    List getAllMenu();
    List<Object> getMenuCuaTiec(int keyword);
    Menu createMenu(Menu menu);
    Boolean isMenuExists(int idTiec, int idThucAn);
    Menu updateSoLuong(int idTiec, int idThucAn, Menu menu);
    void deleteThucAn(int idTiec, int idThucAn);
    void deleteMenu(int idTiec);
}
