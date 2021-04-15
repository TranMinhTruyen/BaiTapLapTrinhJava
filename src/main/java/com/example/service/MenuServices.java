package com.example.service;

import com.example.common.wrapper.MenuWrapper;

import java.util.List;

public interface MenuServices {
    List getAllMenu();
    MenuWrapper getMenuById(long keyword);
    MenuWrapper createMenu(MenuWrapper menu);
    MenuWrapper updateMenu(long idMenu, MenuWrapper menu);
    Boolean deleteMenu(long idMenu);
}
