package com.example.repository;

import com.example.common.entity.Tiec;

import java.util.List;

public interface TiecRepository {
    List getAllTiec();
    Tiec getTiecbyId(int id);
}
