package com.example.service.ServicesImplement;

import com.example.common.entity.Menu;
import com.example.repository.MenuRepository;
import com.example.service.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServicesImp implements MenuServices {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List getAllMenu() {
        return menuRepository.getAllMenu();
    }

    @Override
    public List getMenuCuaTiec(int keyword) {
        return menuRepository.getMenuCuaTiec(keyword);
    }

    @Override
    public List createMenu(List<Menu> menus) {
        return menuRepository.createMenu(menus);
    }

    @Override
    public Menu updateSoLuong(int idTiec, int idThucAn, Menu menu) {
        if (menuRepository.isMenuExists(idTiec,idThucAn))
            return menuRepository.updateSoLuong(idTiec,idThucAn,menu);
        else
            return null;
    }

    @Override
    public Boolean deleteThucAn(int idTiec, int idThucAn) {
        if (menuRepository.isMenuExists(idTiec,idThucAn)) {
            menuRepository.deleteThucAn(idTiec, idThucAn);
            return true;
        }
        else
            return false;
    }

    @Override
    public Boolean deleteMenu(int idTiec) {
        if (!menuRepository.getMenuCuaTiec(idTiec).isEmpty()) {
            menuRepository.deleteMenu(idTiec);
            return true;
        }
        else
            return false;
    }
}
