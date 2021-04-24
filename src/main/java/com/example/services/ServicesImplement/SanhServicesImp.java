package com.example.services.ServicesImplement;

import com.example.common.entity.Sanh;
import com.example.common.request.SanhRequest;
import com.example.common.response.CommonResponse;
import com.example.repository.SanhRepository;
import com.example.services.SanhServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanhServicesImp implements SanhServices {

    @Autowired
    private SanhRepository sanhRepository;

    @Override
    public Object getSanhByKeyword(int page, int size,String keyword) {
        CommonResponse commonResponse = new CommonResponse();
        List result = sanhRepository.getSanhByKeyWord(keyword);
        int offset = (page - 1) * size;
        int total = result.size();
        int totalPage = (total%size) == 0 ? (int)(total/size) : (int)((total / size) + 1);
        Object[] data = result.stream().skip(offset).limit(size).toArray();
        commonResponse.setData(data);
        commonResponse.setTotalPage(totalPage);
        commonResponse.setTotalRecord(total);
        commonResponse.setPage(page);
        commonResponse.setSize(size);
        return commonResponse;
    }

    @Override
    public SanhRequest createSanh(SanhRequest sanh) {
        Sanh newSanh = new Sanh();
        newSanh.setTen(sanh.getTenSanh());
        newSanh.setTen(sanh.getTenSanh());
        newSanh.setGiaTien(sanh.getGiaTien());
        newSanh.setTongSoBan(sanh.getSoBan());
        newSanh.setHinhAnh(sanh.getHinhAnh());
        Sanh result = sanhRepository.createSanh(newSanh);
        if(result != null)
            return sanh;
        else
            return null;
    }

    @Override
    public SanhRequest updateSanh(int id, SanhRequest sanh) {
        Sanh newSanh = new Sanh();
        newSanh.setTen(sanh.getTenSanh());
        newSanh.setGiaTien(sanh.getGiaTien());
        newSanh.setTongSoBan(sanh.getSoBan());
        newSanh.setHinhAnh(sanh.getHinhAnh());
        if (sanhRepository.getSanhById(id) != null) {
            sanhRepository.updateSanh(id, newSanh);
            return sanh;
        }
        else
            return null;
    }

    @Override
    public boolean deleteSanhById(int id) {
        Sanh result = sanhRepository.getSanhById(id);
        if (result != null) {
            sanhRepository.deleteSanhById(id);
            return true;
        }
        else
            return false;
    }

    @Override
    public Object getAllSanh(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = sanhRepository.getAllSanh();
        int offset = (page - 1) * size;
        int total = result.size();
        int totalPage = (total%size) == 0 ? (int)(total/size) : (int)((total / size) + 1);
        Object[] data = result.stream().skip(offset).limit(size).toArray();
        commonResponse.setData(data);
        commonResponse.setTotalPage(totalPage);
        commonResponse.setTotalRecord(total);
        commonResponse.setPage(page);
        commonResponse.setSize(size);
        return commonResponse;
    }
}
