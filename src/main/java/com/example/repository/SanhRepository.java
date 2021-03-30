package com.example.repository;

import com.example.comon.entity.Sanh;

import java.util.List;

public interface SanhRepository {
    List getAllSanh();
    List getSanhByKeyWord(String keyword);
    Sanh createSanh(Sanh sanh);
    Sanh updateSanh(int id, Sanh sanh);
    Sanh getSanhById(int id);
    boolean deleteSanhById(int id);
}
