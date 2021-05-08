package com.example.services.ServicesImplement;

import com.example.common.entity.ThucAn;
import com.example.common.request.ThucAnRequest;
import com.example.common.response.CommonResponse;
import com.example.repository.ThucAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThucAnServicesImp implements com.example.services.ThucAnServices {

    @Autowired
    ThucAnRepository thucAnRepository;

    @Override
    public Object getAllThucAn(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = thucAnRepository.getAllThucAn();
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
    public ThucAnRequest createThucAn(ThucAnRequest thucAn) {

        ThucAn newThucAn = new ThucAn();
        newThucAn.setId(thucAn.getId());
        newThucAn.setTen(thucAn.getTen());
        newThucAn.setLoai(thucAn.getLoai());
        newThucAn.setHinhAnh(thucAn.getHinhAnh());

        ThucAn result = thucAnRepository.createThucAn(newThucAn);

        if(result != null)
            return thucAn;
        else
            return null;
    }

    @Override
    public Object getThucAnByKeyword(int page, int size, String keyword) {
        CommonResponse commonResponse = new CommonResponse();
        List result = thucAnRepository.getThucAnByKeyword(keyword);
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
    public ThucAnRequest updateThucAn(int id, ThucAnRequest thucAn) {
        ThucAn newThucAn = new ThucAn();
        newThucAn.setTen(thucAn.getTen());
        newThucAn.setLoai(thucAn.getLoai());
        newThucAn.setHinhAnh(thucAn.getHinhAnh());
        if (thucAnRepository.getThucAnById(id) != null){
            thucAnRepository.updateThucAn(id, newThucAn);
            return thucAn;
        }
        else
            return null;
    }

    @Override
    public boolean deleteThucAn(int id) {
        if (thucAnRepository.getThucAnById(id) != null){
            thucAnRepository.deleteThucAn(id);
            return true;
        }
        else return false;
    }
}
