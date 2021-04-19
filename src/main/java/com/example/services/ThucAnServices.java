package com.example.services;

import com.example.common.request.ThucAnRequest;
import com.example.common.response.ThucAnResponse;

import java.util.List;

public interface ThucAnServices {
    List getAllThucAn();
    ThucAnRequest createThucAn(ThucAnRequest thucAn);
    ThucAnResponse getThucAnById(int id);
    ThucAnRequest updateThucAn(int id, ThucAnRequest thucAn);
    boolean deleteThucAn(int id);
}
