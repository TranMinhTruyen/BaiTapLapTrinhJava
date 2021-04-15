package com.example.repository;

import com.example.common.entity.MenuThucAn;

import java.util.List;

public interface MenuThucAnRepository {
    MenuThucAn create(MenuThucAn menuThucAns);
    List getMenuThucAnByMenuId(long idMenu);
    boolean isIdThucAnExist(int idThucAn);
    boolean isIdMenuExist(long idMenu);
    void deleteByIdThucAn(int idThucAn);
    void deleteByIdMenu(long idMenu);
    void deleteThucAnByIdMenu(long idMenu, int idThucAn);
}
