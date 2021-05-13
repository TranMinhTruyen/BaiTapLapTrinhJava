package com.example.services.ServicesImplement;

import com.example.common.entity.Menu;
import com.example.common.entity.MenuThucAn;
import com.example.common.entity.MenuThucAnKey;
import com.example.common.request.MenuThucAnRequest;
import com.example.common.response.ListThucAnOfMenuResponse;
import com.example.repository.MenuRepository;
import com.example.repository.MenuThucAnRepository;
import com.example.services.MenuThucAnServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MenuThucAnServicesImp implements MenuThucAnServices {

    @Autowired
    private MenuThucAnRepository menuThucAnRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public MenuThucAnRequest create(MenuThucAnRequest menuThucAn) {
        MenuThucAn newMenuThucAn = new MenuThucAn();
        MenuThucAnKey key = new MenuThucAnKey();
        key.setMenuId(menuThucAn.getIdMenu());
        key.setThucAnId(menuThucAn.getIdThucAn());
        newMenuThucAn.setThucAn(menuThucAn.getIdThucAn());
        newMenuThucAn.setMenu(menuThucAn.getIdMenu());
        newMenuThucAn.setId(key);
        if(menuThucAnRepository.create(newMenuThucAn) != null)
            return menuThucAn;
        else
            return null;
    }

    @Override
    public Object getListThucAnByMenuId(long idMenu) {
        Menu menu = menuRepository.getMenuById(idMenu);
        if (menu != null){
            List thucAns = menuThucAnRepository.getListThucAnByMenuId(idMenu);
            ListThucAnOfMenuResponse listThucAnOfMenuResponse = new ListThucAnOfMenuResponse();
            listThucAnOfMenuResponse.setId(menu.getId());
            listThucAnOfMenuResponse.setTenMenu(menu.getTenMenu());
            listThucAnOfMenuResponse.setThucAnList(thucAns);
            return listThucAnOfMenuResponse;
        }
        else
            return null;
    }

    @Override
    public boolean deleteByIdThucAn(int idThucAn) {
        if (menuThucAnRepository.isIdThucAnExist(idThucAn)){
            menuThucAnRepository.deleteByIdThucAn(idThucAn);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteByIdMenu(int idMenu) {
        if (menuThucAnRepository.isIdMenuExist(idMenu)){
            menuThucAnRepository.deleteByIdMenu(idMenu);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean deleteThucAnByIdMenu(long idMenu, int idThucAn) {
       if (menuThucAnRepository.isIdMenuExist(idMenu) && menuThucAnRepository.isIdThucAnExist(idThucAn)){
           menuThucAnRepository.deleteThucAnByIdMenu(idMenu,idThucAn);
           return true;
       }
       else
           return false;
    }

}
