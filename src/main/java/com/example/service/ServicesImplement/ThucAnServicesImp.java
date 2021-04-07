package com.example.service.ServicesImplement;

import com.example.common.entity.ThucAn;
import com.example.repository.ThucAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ThucAnServicesImp implements com.example.service.ThucAnServices {

    @Autowired
    ThucAnRepository thucAnRepository;

    @Override
    public ThucAn getThucAnById(int id) {
        return thucAnRepository.getThucAnById(id);
    }
}
