package com.example.services.ServicesImplement;

import com.example.common.entity.NhanVien;
import com.example.common.request.NhanVienRequest;
import com.example.common.response.CommonResponse;
import com.example.common.response.NhanVienResponse;
import com.example.repository.NhanVienRepository;
import com.example.services.NhanVienServices;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class NhanVienServicesImp implements NhanVienServices {

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public NhanVienRequest createNhanVien(NhanVienRequest nhanVien) {
        NhanVien newNhanVien  = new NhanVien();
        String matKhauHash = Hashing.sha256().hashString(nhanVien.getMatKhau(), StandardCharsets.UTF_8).toString();
        newNhanVien.setTaiKhoan(nhanVien.getTaiKhoan());
        newNhanVien.setMatKhau(matKhauHash);
        newNhanVien.setHo(nhanVien.getHo());
        newNhanVien.setTen(nhanVien.getTen());
        newNhanVien.setNgaySinh(nhanVien.getNgaySinh());
        newNhanVien.setCmnd(nhanVien.getCmnd());
        newNhanVien.setRole(nhanVien.getRole());
        newNhanVien.setCaLamViec(nhanVien.getCaLamViec());
        newNhanVien.setHinhAnh(nhanVien.getHinhAnh());
        if (nhanVienRepository.createNhanVien(newNhanVien) != null)
            return nhanVien;
        else
            return null;
    }

    @Override
    public Object getAllNhanVien(int page, int size) {
        CommonResponse commonResponse = new CommonResponse();
        List result = nhanVienRepository.getAllNhanVien();
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
    public Object getNhanVienByKeyword(int page, int size, String keyword) {
        CommonResponse commonResponse = new CommonResponse();
        List result = nhanVienRepository.getNhanVienByKeyword(keyword);
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
    public NhanVienResponse getNhanVienByTaiKhoanMatKhau(String taiKhoan, String matKhau) {
        String matKhauHash = Hashing.sha256().hashString(matKhau, StandardCharsets.UTF_8).toString();
        NhanVien result = nhanVienRepository.getNhanVienByTaiKhoanMatKhau(taiKhoan,matKhauHash);
        NhanVienResponse nhanVienResponse = new NhanVienResponse();
        nhanVienResponse.setHo(result.getHo());
        nhanVienResponse.setTen(result.getTen());
        nhanVienResponse.setNgaySinh(result.getNgaySinh().toString());
        nhanVienResponse.setCmnd(result.getCmnd());
        nhanVienResponse.setRole(result.getRole());
        nhanVienResponse.setCaLamViec(result.getCaLamViec());
        nhanVienResponse.setHinhAnh(result.getHinhAnh());
        return nhanVienResponse;
    }

    @Override
    public NhanVienRequest updateNhanVienById(int id, NhanVienRequest nhanVien) {
        NhanVien newNhanVien = new NhanVien();
        newNhanVien.setMatKhau(nhanVien.getMatKhau());
        newNhanVien.setHo(nhanVien.getHo());
        newNhanVien.setTen(nhanVien.getTen());
        newNhanVien.setNgaySinh(nhanVien.getNgaySinh());
        newNhanVien.setCmnd(nhanVien.getCmnd());
        newNhanVien.setRole(nhanVien.getRole());
        newNhanVien.setCaLamViec(nhanVien.getCaLamViec());
        newNhanVien.setHinhAnh(nhanVien.getHinhAnh());
        if (nhanVienRepository.getNhanVienById(id) != null){
            nhanVienRepository.updateNhanVienById(id, newNhanVien);
            return nhanVien;
        }
        else
            return null;
    }

    @Override
    public boolean deleteNhanVienById(int id) {
        if (nhanVienRepository.getNhanVienById(id) != null){
            nhanVienRepository.deleteNhanVienById(id);
            return true;
        }
        else
            return false;
    }
}
