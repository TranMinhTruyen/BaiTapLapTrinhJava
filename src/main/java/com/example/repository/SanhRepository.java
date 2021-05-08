package com.example.repository;

import com.example.common.entity.Sanh;

import java.util.List;

public interface SanhRepository {
    List getAllSanh();
    List getSanhByKeyWord(String keyword);
    Sanh createSanh(Sanh sanh);
    void updateSanh(int id, Sanh sanh);
    Sanh getSanhById(int id);
    void deleteSanhById(int id);
}
