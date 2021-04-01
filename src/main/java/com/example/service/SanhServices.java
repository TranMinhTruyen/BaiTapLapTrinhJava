package com.example.service;

import com.example.common.entity.Sanh;


public interface SanhServices {
//    Object getAllSanh(int page, int size);
    Object getSanhByKeyword(int page, int size, String keyword);
    Sanh createSanh(Sanh sanh);
    Sanh updateSanh(int id, Sanh sanh);
    boolean deleteSanhById(int id);
}
