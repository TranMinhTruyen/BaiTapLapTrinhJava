package com.example.services;

import com.example.common.request.TiecRequest;

import java.util.List;

public interface TiecServices {
    TiecRequest createTiec(TiecRequest tiecWrapper);
    Object getAllTiec(int page, int size);
    Object getTiecByKeyword(int page, int size, String keyword);
    TiecRequest updateTiec(int id, TiecRequest tiecWrapper);
    boolean deleteTiec(int id);
}
