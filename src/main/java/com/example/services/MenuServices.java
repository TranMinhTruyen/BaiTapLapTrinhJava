package com.example.services;

import com.example.common.request.MenuRequest;
import com.example.common.wrapper.MenuWrapper;

import java.util.List;

public interface MenuServices {
    List getAllMenu();
    MenuWrapper getMenuById(long keyword);
    MenuRequest createMenu(MenuRequest menu);
    MenuRequest updateMenu(long idMenu, MenuRequest menu);
    Boolean deleteMenu(long idMenu);
}
