package com.example.repository;

import com.example.common.entity.ThucAn;

import java.util.List;

public interface ThucAnRepository {
    List getAllThucAn();
    ThucAn createThucAn(ThucAn thucAn);
    List getThucAnByKeyword(String keyword);
    ThucAn getThucAnById(int id);
    void updateThucAn(int id, ThucAn thucAn);
    void deleteThucAn(int id);
}
