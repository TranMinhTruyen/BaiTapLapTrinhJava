package com.example.services;

import com.example.common.request.SanhRequest;

import java.util.List;


public interface SanhServices {
    List getAllSanh();
    List getSanhByKeyword(String keyword);
    SanhRequest createSanh(SanhRequest sanh);
    SanhRequest updateSanh(int id, SanhRequest sanh);
    boolean deleteSanhById(int id);
}
