package com.example.services.ServicesImplement;

import com.example.common.entity.CaLamViec;
import com.example.common.request.CaLamViecRequest;
import com.example.common.response.CaLamViecResponse;
import com.example.common.response.CommonResponse;
import com.example.repository.CaLamViecRepository;
import com.example.services.CaLamViecServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaLamViecServicesImp implements CaLamViecServices {

    @Autowired
    private CaLamViecRepository caLamViecRepository;

    @Override
    public Object getAllCaLamViec(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = caLamViecRepository.getAllCalamViec();
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
    public CaLamViecRequest createCaLamViec(CaLamViecRequest caLamViecRequest) {
        CaLamViec newCaLamViec = new CaLamViec();
        newCaLamViec.setCaLam(caLamViecRequest.getCaLam());
        if(caLamViecRepository.createCaLamViec(newCaLamViec) != null)
            return caLamViecRequest;
        else
            return null;
    }

    @Override
    public Object getCaLamViecByKeyword(int page, int size, String keyword) {
        CommonResponse commonResponse = new CommonResponse();
        List result = caLamViecRepository.getCaLamViecByKeyword(keyword);
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
    public CaLamViecResponse getCaLamViecById(int id) {
        CaLamViec result = caLamViecRepository.getCaLamViecById(id);
        if (result != null){
            CaLamViecResponse caLamViecResponse = new CaLamViecResponse();
            caLamViecResponse.setId(result.getId());
            caLamViecResponse.setCaLam(result.getCaLam());
            return caLamViecResponse;
        }
        else
            return null;
    }

    @Override
    public CaLamViecRequest updateCaLamViec(int id, CaLamViecRequest caLamViecRequest) {
        CaLamViec newCaLamViec = new CaLamViec();
        newCaLamViec.setCaLam(caLamViecRequest.getCaLam());
        if (caLamViecRepository.getCaLamViecById(id) != null){
            caLamViecRepository.updateCaLamViec(id, newCaLamViec);
            return caLamViecRequest;
        }
        else
            return null;
    }

    @Override
    public boolean deleteCaLamViec(int id) {
        if (caLamViecRepository.getCaLamViecById(id) != null){
            caLamViecRepository.deleteCaLamViec(id);
            return true;
        }
        else
            return false;
    }
}
