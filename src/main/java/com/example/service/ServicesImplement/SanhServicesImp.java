package com.example.service.ServicesImplement;

import com.example.common.response.CommonResponse;
import com.example.common.entity.Sanh;
import com.example.common.wrapper.SanhWrapper;
import com.example.repository.SanhRepository;
import com.example.service.SanhServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SanhServicesImp implements SanhServices {

    @Autowired
    private SanhRepository sanhRepository;

    @Override
    public Object getSanhByKeyword(int page, int size, String keyword) {
        CommonResponse result = new CommonResponse();
        int offset = (page - 1) * size;
        int total = sanhRepository.getSanhByKeyWord(keyword).size();
        int totalPage = (total%size) == 0 ? (int)(total/size) : (int)((total / size) + 1);
        Object[] data = sanhRepository.getSanhByKeyWord(keyword).stream().skip(offset).limit(size).toArray();
        result.setData(data);
        result.setTotalPage(totalPage);
        result.setTotalRecord(total);
        result.setPage(page);
        result.setSize(size);
        return result;
    }

    @Override
    public SanhWrapper createSanh(SanhWrapper sanh) {
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
    public Sanh updateSanh(int id, Sanh sanh) {
        Sanh result = sanhRepository.getSanhById(id);
        if (result != null) {
            return sanhRepository.updateSanh(id, sanh);
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

//    @Override
//    public Object getAllSanh(int page, int size) {
//        CommonResponse result = new CommonResponse();
//        int offset = (page - 1) * size;
//        int total = sanhRepository.getAllSanh().size();
//        int totalPage = (total%size) == 0 ? (int)(total/size) : (int)((total / size) + 1);
//        Object[] data = sanhRepository.getAllSanh().stream().skip(offset).limit(size).toArray();
//        result.setData(data);
//        result.setTotalPage(totalPage);
//        result.setTotalRecord(total);
//        result.setPage(page);
//        result.setSize(size);
//        return result;
//    }
}
