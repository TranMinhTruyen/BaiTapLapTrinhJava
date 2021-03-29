package com.example.service;

import com.example.entity.Sanh;

import java.util.List;

public interface SanhServices {
    List <Sanh> getAllSanh();
    Sanh createSanh(Sanh sanh);
}
