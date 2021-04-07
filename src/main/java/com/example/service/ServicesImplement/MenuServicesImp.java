package com.example.service.ServicesImplement;

import com.example.common.entity.Menu;
import com.example.common.wrapper.CommonResponse;
import com.example.repository.MenuRepository;
import com.example.repository.ThucAnRepository;
import com.example.repository.TiecRepository;
import com.example.service.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServicesImp implements MenuServices {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ThucAnRepository thucAnRepository;

    @Autowired
    private TiecRepository tiecRepository;

    @Override
    public List getAllMenu() {
        return menuRepository.getAllMenu();
    }

    @Override
    public Object getMenuCuaTiec(int page, int size, int keyword) {
        CommonResponse result = new CommonResponse();
        int offset = (page - 1) * size;
        int total = menuRepository.getMenuCuaTiec(keyword).size();
        int totalPage = (total%size) == 0 ? (int)(total/size) : (int)((total / size) + 1);
        Object[] data = menuRepository.getMenuCuaTiec(keyword).stream().skip(offset).limit(size).toArray();
        result.setData(data);
        result.setTotalPage(totalPage);
        result.setTotalRecord(total);
        result.setPage(page);
        result.setSize(size);
        return result;
    }

    @Override
    public Menu createMenu(Menu menu) {
        if (tiecRepository.getTiecbyId(menu.getTiec()) != null
                && thucAnRepository.getThucAnById(menu.getThucAn()) != null){
            return menuRepository.createMenu(menu);
        }
        else {
            return null;
        }
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
