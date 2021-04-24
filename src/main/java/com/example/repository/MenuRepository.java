package com.example.repository;

import com.example.common.entity.Menu;

import java.util.List;

public interface MenuRepository {
    List getAllMenu();
    List getMenuByKeyword(String keyword);
    Menu getMenuById(long id);
    Menu createMenu(Menu menu);
    void updateMenu(long idMenu, Menu menu);
    void deleteMenu(long idMenu);
}
