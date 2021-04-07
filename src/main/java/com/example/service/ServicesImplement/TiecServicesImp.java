package com.example.service.ServicesImplement;

import com.example.common.entity.Tiec;
import com.example.service.TiecServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiecServicesImp implements TiecServices {

    @Autowired
    TiecServices tiecServices;
    @Override
    public List getAllTiec() {
        return null;
    }

    @Override
    public Tiec getTiecbyId(int id) {
        return tiecServices.getTiecbyId(id);
    }
}
