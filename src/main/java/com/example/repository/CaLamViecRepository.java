package com.example.repository;

import com.example.common.entity.CaLamViec;

import java.util.List;

public interface CaLamViecRepository {
    List getAllCalamViec();
    CaLamViec createCaLamViec(CaLamViec caLamViec);
    List getCaLamViecByKeyword(String keyword);
    CaLamViec getCaLamViecById(int id);
    void updateCaLamViec(int id, CaLamViec caLamViec);
    void deleteCaLamViec(int id);
}
