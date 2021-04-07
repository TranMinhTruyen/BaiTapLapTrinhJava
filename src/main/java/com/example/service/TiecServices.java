package com.example.service;

import com.example.common.entity.Tiec;

import java.util.List;

public interface TiecServices {
    List getAllTiec();
    Tiec getTiecbyId(int id);
}
