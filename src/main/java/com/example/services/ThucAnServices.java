package com.example.services;

import com.example.common.request.ThucAnRequest;

public interface ThucAnServices {
    Object getAllThucAn(int page, int size);
    ThucAnRequest createThucAn(ThucAnRequest thucAn);
    Object getThucAnByKeyword(int page, int size, String keyword);
    ThucAnRequest updateThucAn(int id, ThucAnRequest thucAn);
    boolean deleteThucAn(int id);
}
