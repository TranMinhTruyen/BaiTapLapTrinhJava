package com.example.services.ServicesImplement;

import com.example.common.entity.Sanh;
import com.example.common.request.SanhRequest;
import com.example.repository.SanhRepository;
import com.example.services.SanhServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanhServicesImp implements SanhServices {

    @Autowired
    private SanhRepository sanhRepository;

    @Override
    public List getSanhByKeyword(String keyword) {
        return sanhRepository.getSanhByKeyWord(keyword);
    }

    @Override
    public SanhRequest createSanh(SanhRequest sanh) {
        Sanh newSanh = new Sanh();
        newSanh.setTen(sanh.getTenSanh());
        newSanh.setTen(sanh.getTenSanh());
        newSanh.setGiaTien(sanh.getGiaTien());
        newSanh.setTongSoBan(sanh.getSoBan());
        newSanh.setHinhAnh(sanh.getHinhAnh());
        Sanh result = sanhRepository.createSanh(newSanh);
        if(result != null)
            return sanh;
        else
            return null;
    }

    @Override
    public SanhRequest updateSanh(int id, SanhRequest sanh) {
        Sanh newSanh = new Sanh();
        newSanh.setTen(sanh.getTenSanh());
        newSanh.setGiaTien(sanh.getGiaTien());
        newSanh.setTongSoBan(sanh.getSoBan());
        newSanh.setHinhAnh(sanh.getHinhAnh());
        if (sanhRepository.getSanhById(id) != null) {
            sanhRepository.updateSanh(id, newSanh);
            return sanh;
        }
        else
            return null;
    }

    @Override
    public boolean deleteSanhById(int id) {
        Sanh result = sanhRepository.getSanhById(id);
        if (result != null) {
            sanhRepository.deleteSanhById(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public List getAllSanh() {
        return sanhRepository.getAllSanh();
    }
}
