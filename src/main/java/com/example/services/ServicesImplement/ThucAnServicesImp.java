package com.example.services.ServicesImplement;

import com.example.common.entity.ThucAn;
import com.example.common.request.ThucAnRequest;
import com.example.common.wrapper.ThucAnWrapper;
import com.example.repository.ThucAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThucAnServicesImp implements com.example.services.ThucAnServices {

    @Autowired
    ThucAnRepository thucAnRepository;

    @Override
    public List getAllThucAn() {
        return thucAnRepository.getAllThucAn();
    }

    @Override
    public ThucAnRequest createThucAn(ThucAnRequest thucAn) {

        ThucAn newThucAn = new ThucAn();
        newThucAn.setId(thucAn.getId());
        newThucAn.setTen(thucAn.getTen());
        newThucAn.setGiaTien(thucAn.getGiaTien());
        newThucAn.setHinhAnh(thucAn.getHinhAnh());

        ThucAn result = thucAnRepository.createThucAn(newThucAn);

        if(result != null)
            return thucAn;
        else
            return null;
    }

    @Override
    public ThucAnWrapper getThucAnById(int id) {
        ThucAn result = thucAnRepository.getThucAnById(id);
        if (result != null){
            ThucAnWrapper thucAnWrapper = new ThucAnWrapper();
            thucAnWrapper.setId(result.getId());
            thucAnWrapper.setTen(result.getTen());
            thucAnWrapper.setGiaTien(result.getGiaTien());
            thucAnWrapper.setHinhAnh(result.getHinhAnh());
            return thucAnWrapper;
        }
        else
            return null;
    }


    @Override
    public ThucAnRequest updateThucAn(int id, ThucAnRequest thucAn) {
        ThucAn newThucAn = new ThucAn();
        newThucAn.setTen(thucAn.getTen());
        newThucAn.setGiaTien(thucAn.getGiaTien());
        newThucAn.setHinhAnh(thucAn.getHinhAnh());
        if (thucAnRepository.getThucAnById(id) != null){
            thucAnRepository.updateThucAn(id, newThucAn);
            return thucAn;
        }
        else
            return null;
    }

    @Override
    public boolean deleteThucAn(int id) {
        if (thucAnRepository.getThucAnById(id) != null){
            thucAnRepository.deleteThucAn(id);
            return true;
        }
        else return false;
    }
}
