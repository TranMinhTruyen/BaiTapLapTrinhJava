package com.example.services;

import com.example.common.request.TiecRequest;
import com.example.common.wrapper.TiecWrapper;

import java.util.List;

public interface TiecServices {
    TiecRequest createTiec(TiecRequest tiecWrapper);
    List getAllTiec();
    Object getTiecByKeyword(int page, int size, String keyword);
    TiecRequest updateTiec(int id, TiecRequest tiecWrapper);
    boolean deleteTiec(int id);
}
