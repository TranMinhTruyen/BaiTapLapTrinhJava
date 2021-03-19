package com.example.repository;

import com.example.entity.Khoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhoaReponsitory extends JpaRepository<Khoa, Integer> {
    Khoa findKhoaById(int id);
}
