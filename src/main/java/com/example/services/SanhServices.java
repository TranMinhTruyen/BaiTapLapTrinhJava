package com.example.services;

import com.example.common.request.SanhRequest;


public interface SanhServices {
    Object getAllSanh(int page, int size);
    Object getSanhByKeyword(int page, int size,String keyword);
    SanhRequest createSanh(SanhRequest sanh);
    SanhRequest updateSanh(int id, SanhRequest sanh);
    boolean deleteSanhById(int id);
}
