package com.example.repository;

import com.example.common.entity.Tiec;

import java.util.List;

public interface TiecRepository {
    Tiec createTiec(Tiec tiec);
    List getAllTiec();
    List getTiecByKeyword(String keyword);
    boolean isTiecExist(int id);
    void updateTiec(int id, Tiec tiec);
    void deleteTiec(int id);
}
