package com.example.services.ServicesImplement;

import com.example.common.entity.Menu;
import com.example.common.request.MenuRequest;
import com.example.common.wrapper.MenuWrapper;
import com.example.repository.MenuRepository;
import com.example.repository.MenuThucAnRepository;
import com.example.services.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServicesImp implements MenuServices {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuThucAnRepository menuThucAnRepository;

    @Override
    public List getAllMenu() {
        return menuRepository.getAllMenu();
    }

    @Override
    public MenuWrapper getMenuById(long keyword) {
        Menu result = menuRepository.getMenuById(keyword);
        if (result != null){
            MenuWrapper menuWrapper = new MenuWrapper();
            menuWrapper.setId(result.getId());
            menuWrapper.setTenMenu(result.getTenMenu());
            return menuWrapper;
        }
        else
            return null;
    }

    @Override
    public MenuRequest createMenu(MenuRequest menu) {

        Menu var = new Menu();
        var.setId(menu.getId());
        var.setTenMenu(menu.getTenMenu());
        Menu result = menuRepository.createMenu(var);
        if(result != null)
            return menu;
        else
            return null;
    }

    @Override
    public MenuRequest updateMenu(long idMenu, MenuRequest menu) {
        Menu var = new Menu();
        var.setId(menu.getId());
        var.setTenMenu(menu.getTenMenu());
        if (menuRepository.getMenuById(idMenu) != null){
            menuRepository.updateMenu(idMenu, var);
            return menu;
        }
        else
            return null;
    }


    @Override
    public Boolean deleteMenu(long idMenu) {
        if (menuRepository.getMenuById(idMenu) != null){
            menuThucAnRepository.deleteByIdMenu(idMenu);
            menuRepository.deleteMenu(idMenu);
            return true;
        }
        else
            return false;
    }
}
