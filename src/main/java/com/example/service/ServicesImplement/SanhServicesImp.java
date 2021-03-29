package com.example.service.ServicesImplement;

import com.example.entity.Sanh;
import com.example.repository.SanhRepository;
import com.example.service.SanhServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanhServicesImp implements SanhServices {

    @Autowired
    private SanhRepository sanhRepository;


    @Override
    public List<Sanh> getAllSanh() {
        return sanhRepository.getAllSanh();
    }

    @Override
    public Sanh createSanh(Sanh sanh) {
        return sanhRepository.createSanh(sanh);
    }
}
