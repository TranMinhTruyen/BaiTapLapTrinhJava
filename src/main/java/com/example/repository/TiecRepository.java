package com.example.repository;

import com.example.common.entity.Tiec;

import java.util.List;

public interface TiecRepository {
    List getAllTiec();
    Tiec getTiecbyId(int id);
    Tiec creatTiec(Tiec tiec);
    List getTiecByKeyword(String keyword);
    Tiec updateTiec(int id, Tiec tiec);
    void deleteTiec(int id);
}
