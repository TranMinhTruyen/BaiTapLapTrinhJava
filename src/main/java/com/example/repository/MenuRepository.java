package com.example.repository;

import com.example.common.entity.Menu;

import java.util.List;

public interface MenuRepository {
    List getAllMenu();
    Menu getMenuById(long keyword);
    Menu createMenu(Menu menu);
    Menu updateMenu(long idMenu, Menu menu);
    void deleteMenu(long idMenu);
}
