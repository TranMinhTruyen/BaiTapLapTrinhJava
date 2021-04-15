package com.example.service.ServicesImplement;

import com.example.common.entity.Tiec;
import com.example.common.response.CommonResponse;
import com.example.repository.TiecRepository;
import com.example.service.TiecServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiecServicesImp implements TiecServices {

    @Autowired
    TiecRepository tiecRepository;

    @Override
    public List getAllTiec() {
        return null;
    }

    @Override
    public Tiec getTiecbyId(int id) {
        return tiecRepository.getTiecbyId(id);
    }

    @Override
    public Tiec creatTiec(Tiec tiec) {
        return tiecRepository.creatTiec(tiec);
    }

    @Override
    public Object getTiecByKeyword(int page, int size, String keyword) {
        CommonResponse result = new CommonResponse();
        int offset = (page - 1) * size;
        int total = tiecRepository.getTiecByKeyword(keyword).size();
        int totalPage = (total%size) == 0 ? (int)(total/size) : (int)((total / size) + 1);
        Object[] data = tiecRepository.getTiecByKeyword(keyword).stream().skip(offset).limit(size).toArray();
        result.setData(data);
        result.setTotalPage(totalPage);
        result.setTotalRecord(total);
        result.setPage(page);
        result.setSize(size);
        return result;
    }

    @Override
    public Tiec updateTiec(int id, Tiec tiec) {
        if (tiecRepository.getTiecbyId(id) != null){
            return tiecRepository.updateTiec(id, tiec);
        }
        else return null;
    }

    @Override
    public Boolean deleteTiec(int id) {
        if (tiecRepository.getTiecbyId(id) != null){
            tiecRepository.deleteTiec(id);
            return true;
        }
        else return false;
    }
}
