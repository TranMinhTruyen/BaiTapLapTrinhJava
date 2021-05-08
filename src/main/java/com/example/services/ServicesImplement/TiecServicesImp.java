package com.example.services.ServicesImplement;

import com.example.common.entity.Tiec;
import com.example.common.request.TiecRequest;
import com.example.common.response.CommonResponse;
import com.example.repository.TiecRepository;
import com.example.services.TiecServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiecServicesImp implements TiecServices {

    @Autowired
    private TiecRepository tiecRepository;

    public TiecRequest createTiec(TiecRequest tiecRequest) {
        Tiec newTiec = new Tiec();
        newTiec.setCaLamViec(tiecRequest.getCaLamViec());
        newTiec.setMenu(tiecRequest.getMenu());
        newTiec.setSanh(tiecRequest.getSanh());
        newTiec.setKhachHang(tiecRequest.getKhachHang());
        newTiec.setLoai(tiecRequest.getLoai());
        newTiec.setNgayBatDau(tiecRequest.getNgayToChuc());
        newTiec.setThoiGianBatDau(tiecRequest.getThoiGian());
        newTiec.setTrangThai(tiecRequest.getTrangThai());
        if (tiecRepository.createTiec(newTiec) != null)
            return tiecRequest;
        else
            return null;
    }

    @Override
    public Object getAllTiec(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = tiecRepository.getAllTiec();
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
    public Object getTiecByKeyword(int page, int size, String keyword) {
        CommonResponse commonResponse = new CommonResponse();
        List result = tiecRepository.getTiecByKeyword(keyword);
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
    public TiecRequest updateTiec(int id, TiecRequest tiecRequest) {
        Tiec newTiec = new Tiec();
        newTiec.setThoiGianBatDau(tiecRequest.getThoiGian());
        newTiec.setNgayBatDau(tiecRequest.getNgayToChuc());
        newTiec.setCaLamViec(tiecRequest.getCaLamViec());
        newTiec.setSanh(tiecRequest.getSanh());
        newTiec.setMenu(tiecRequest.getMenu());
        newTiec.setLoai(tiecRequest.getLoai());
        if (tiecRepository.isTiecExist(id)){
            tiecRepository.updateTiec(id,newTiec);
            return tiecRequest;
        }
        else
            return null;
    }

    @Override
    public boolean deleteTiec(int id) {
        if (tiecRepository.isTiecExist(id)){
            tiecRepository.deleteTiec(id);
            return true;
        }
        else
            return false;
    }
}
