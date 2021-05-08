package com.example.services;

import com.example.common.request.CaLamViecRequest;
import com.example.common.response.CaLamViecResponse;

public interface CaLamViecServices {
    Object getAllCaLamViec(int page, int size);
    CaLamViecRequest createCaLamViec (CaLamViecRequest caLamViecRequest);
    Object getCaLamViecByKeyword(int page, int size, String keyword);
    CaLamViecResponse getCaLamViecById(int id);
    CaLamViecRequest updateCaLamViec(int id, CaLamViecRequest caLamViecRequest);
    boolean deleteCaLamViec(int id);
}
