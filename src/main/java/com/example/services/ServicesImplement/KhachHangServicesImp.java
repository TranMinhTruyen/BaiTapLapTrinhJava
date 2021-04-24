package com.example.services.ServicesImplement;

import com.example.common.entity.KhachHang;
import com.example.common.request.KhachHangRequest;
import com.example.common.response.CommonResponse;
import com.example.common.response.KhachHangResponse;
import com.example.repository.KhachHangRepository;
import com.example.services.KhachHangServices;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class KhachHangServicesImp implements KhachHangServices {
    
    @Autowired
    KhachHangRepository khachHangRepository;
    
    @Override
    public KhachHangRequest createKhachHang(KhachHangRequest khachHang) {
        KhachHang newKhachHang = new KhachHang();
        String matKhauHash = Hashing.sha256().hashString(khachHang.getMatKhau(), StandardCharsets.UTF_8).toString();
        newKhachHang.setTaiKhoan(khachHang.getTaiKhoan());
        newKhachHang.setMatKhau(matKhauHash);
        newKhachHang.setHo(khachHang.getHo());
        newKhachHang.setTen(khachHang.getTen());
        newKhachHang.setNgaySinh(khachHang.getNgaySinh());
//        newKhachHang.setHinhAnh(khachHang.getHinhAnh());
        if (khachHangRepository.createKhachHang(newKhachHang) != null)
            return khachHang;
        else 
            return null;
    }

    @Override
    public Object getAllKhachHang(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = khachHangRepository.getAllKhachHang();
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
    public Object getKhachHangByKeyword(int page, int size, String keyword) {
        CommonResponse commonResponse = new CommonResponse();
        List result = khachHangRepository.getKhachHangByKeyword(keyword);
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
    public KhachHangResponse getKhachHangByTaiKhoanMatKhau(String taiKhoan, String matKhau) {
        String matKhauHash = Hashing.sha256().hashString(matKhau, StandardCharsets.UTF_8).toString();
        KhachHang result = khachHangRepository.getKhachHangByTaiKhoanMatKhau(taiKhoan,matKhauHash);
        KhachHangResponse khachHangResponse = new KhachHangResponse();
        khachHangResponse.setId(result.getId());
        khachHangResponse.setTaiKhoan(result.getTaiKhoan());
        khachHangResponse.setMatKhau(result.getMatKhau());
        khachHangResponse.setHo(result.getHo());
        khachHangResponse.setTen(result.getTen());
        khachHangResponse.setNgaySinh(result.getNgaySinh().toString());
        khachHangResponse.setHinhAnh(result.getHinhAnh());
        return khachHangResponse;
    }

    @Override
    public KhachHangRequest updateKhachHangById(int id, KhachHangRequest khachHang) {
        KhachHang newKhachHang = new KhachHang();
        newKhachHang.setMatKhau(khachHang.getMatKhau());
        newKhachHang.setHo(khachHang.getHo());
        newKhachHang.setTen(khachHang.getTen());
        newKhachHang.setNgaySinh(khachHang.getNgaySinh());
//        newKhachHang.setHinhAnh(khachHang.getHinhAnh());
        if (khachHangRepository.getKhachHangById(id) != null){
            khachHangRepository.updateKhachHangById(id, newKhachHang);
            return khachHang;
        }
        else
            return null;
    }

    @Override
    public boolean deleteKhachHangById(int id) {
        if (khachHangRepository.getKhachHangById(id) != null){
            khachHangRepository.deleteKhachHangById(id);
            return true;
        }
        else
            return false;
    }
}
