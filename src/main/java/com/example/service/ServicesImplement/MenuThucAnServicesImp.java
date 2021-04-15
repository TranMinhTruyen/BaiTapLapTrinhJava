package com.example.service.ServicesImplement;

import com.example.common.entity.MenuThucAn;
import com.example.repository.MenuThucAnRepository;
import com.example.service.MenuThucAnServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MenuThucAnServicesImp implements MenuThucAnServices {

    @Autowired
    private MenuThucAnRepository menuThucAnRepository;

    @Override
    public MenuThucAn create(MenuThucAn menuThucAns) {
        return menuThucAnRepository.create(menuThucAns);
    }

    @Override
    public List getMenuThucAnByMenuId(long idMenu) {
        return menuThucAnRepository.getMenuThucAnByMenuId(idMenu);
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
