package com.example.service;

import com.example.common.entity.Tiec;

import java.util.List;

public interface TiecServices {
    List getAllTiec();
    Tiec getTiecbyId(int id);
    Tiec creatTiec(Tiec tiec);
    Object getTiecByKeyword(int page, int size, String keyword);
    Tiec updateTiec(int id, Tiec tiec);
    Boolean deleteTiec(int id);
}
