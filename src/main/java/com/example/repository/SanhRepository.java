package com.example.repository;

import com.example.entity.Sanh;

import java.util.List;

public interface SanhRepository {
    List getAllSanh();
    Sanh createSanh(Sanh sanh);
}
