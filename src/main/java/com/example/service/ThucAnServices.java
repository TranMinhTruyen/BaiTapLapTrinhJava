package com.example.service;

import com.example.common.entity.ThucAn;

import java.util.List;

public interface ThucAnServices {
    List getAllThucAn();
    ThucAn createThucAn(ThucAn thucAn);
    ThucAn getThucAnById(int id);
    ThucAn updateThucAn(int id, ThucAn thucAn);
    boolean deleteThucAn(int id);
}
