package com.example.services;

import com.example.common.request.ThucAnRequest;
import com.example.common.wrapper.ThucAnWrapper;

import java.util.List;

public interface ThucAnServices {
    List getAllThucAn();
    ThucAnRequest createThucAn(ThucAnRequest thucAn);
    ThucAnWrapper getThucAnById(int id);
    ThucAnRequest updateThucAn(int id, ThucAnRequest thucAn);
    boolean deleteThucAn(int id);
}
