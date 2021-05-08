package com.example.services.ServicesImplement;

import com.example.common.entity.PhanHoi;
import com.example.common.request.PhanHoiRequest;
import com.example.common.response.CommonResponse;
import com.example.common.response.PhanHoiResponse;
import com.example.repository.PhanHoiRepository;
import com.example.services.PhanHoiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhanHoiServicesImp implements PhanHoiServices {

    @Autowired
    private PhanHoiRepository phanHoiRepository;

    @Override
    public Object getAllPhanHoi(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = phanHoiRepository.getAllPhanHoi();
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
    public PhanHoiRequest createPhanHoi(PhanHoiRequest phanHoiRequest) {
        PhanHoi newPhanHoi = new PhanHoi();
        newPhanHoi.setId(phanHoiRequest.getId());
        newPhanHoi.setNoiDung(phanHoiRequest.getNoiDung());
        newPhanHoi.setTiec(phanHoiRequest.getIdTiec());
        newPhanHoi.setKhachHang(phanHoiRequest.getIdKhachHang());
        if(phanHoiRepository.createPhanHoi(newPhanHoi) != null)
            return phanHoiRequest;
        else
            return null;
    }

    @Override
    public Object getPhanHoiByKeyword(int page, int size, String keyword) {
        CommonResponse commonResponse = new CommonResponse();
        List result = phanHoiRepository.getPhanHoiByKeyword(keyword);
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
    public PhanHoiResponse getPhanHoiById(int idTiec, int idKhachHang) {
        PhanHoi result = phanHoiRepository.getPhanHoiById(idTiec,idKhachHang);
        if (result != null){
            PhanHoiResponse phanHoiResponse = new PhanHoiResponse();
            phanHoiResponse.setId(result.getId());
            phanHoiResponse.setNoiDung(result.getNoiDung());
            phanHoiResponse.setIdTiec(result.getTiec());
            phanHoiResponse.setIdKhachHang(result.getKhachHang());
            return phanHoiResponse;
        }
        else
            return null;
    }

    @Override
    public PhanHoiRequest updatePhanHoi(int idTiec, int idKhachHang, PhanHoiRequest phanHoiRequest) {
        PhanHoi newPhanHoi = new PhanHoi();
        newPhanHoi.setNoiDung(phanHoiRequest.getNoiDung());
        if (phanHoiRepository.getPhanHoiById(idTiec,idKhachHang) != null){
            phanHoiRepository.updatePhanHoi(idTiec, idKhachHang, newPhanHoi);
            return phanHoiRequest;
        }
        else
            return null;
    }

    @Override
    public boolean deletePhanHoi(int idTiec, int idKhachHang) {
        if (phanHoiRepository.getPhanHoiById(idTiec, idKhachHang) != null){
            phanHoiRepository.deletePhanHoi(idTiec, idKhachHang);
            return true;
        }
        else
            return false;
    }
}
