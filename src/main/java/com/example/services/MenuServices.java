package com.example.services;

import com.example.common.request.MenuRequest;
import com.example.common.response.MenuResponse;

public interface MenuServices {
    Object getAllMenu(int page, int size);
    Object getMenuByKeyword(int page, int size, String keyword);
    MenuResponse getMenuById(long keyword);
    MenuRequest createMenu(MenuRequest menu);
    MenuRequest updateMenu(long idMenu, MenuRequest menu);
    Boolean deleteMenu(long idMenu);
}
