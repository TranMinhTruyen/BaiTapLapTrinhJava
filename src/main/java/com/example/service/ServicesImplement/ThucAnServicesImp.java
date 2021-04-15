package com.example.service.ServicesImplement;

import com.example.common.entity.ThucAn;
import com.example.repository.ThucAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThucAnServicesImp implements com.example.service.ThucAnServices {

    @Autowired
    ThucAnRepository thucAnRepository;

    @Override
    public List getAllThucAn() {
        return null;
    }

    @Override
    public ThucAn createThucAn(ThucAn thucAn) {
        return thucAnRepository.createThucAn(thucAn);
    }

    @Override
    public ThucAn getThucAnById(int id) {
        return thucAnRepository.getThucAnById(id);
    }


    @Override
    public ThucAn updateThucAn(int id, ThucAn thucAn) {
        if (thucAnRepository.getThucAnById(id) != null){
            return thucAnRepository.updateThucAn(id, thucAn);
        }
        else return null;
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
