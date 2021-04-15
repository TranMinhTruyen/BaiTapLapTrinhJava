package com.example.service;

import com.example.common.entity.Sanh;
import com.example.common.wrapper.SanhWrapper;


public interface SanhServices {
    Object getSanhByKeyword(int page, int size, String keyword);
    SanhWrapper createSanh(SanhWrapper sanh);
    Sanh updateSanh(int id, Sanh sanh);
    boolean deleteSanhById(int id);
}
