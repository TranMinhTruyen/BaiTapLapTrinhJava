package com.example.common.user;

import com.example.common.entity.KhachHang;
import com.example.common.entity.NhanVien;
import com.example.repository.KhachHangRepository;
import com.example.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServices  implements UserDetailsService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        NhanVien nhanVien = nhanVienRepository.getNhanVienByTaiKhoan(username);
        KhachHang khachHang = khachHangRepository.getKhachHangByTaiKhoan(username);
        if (nhanVien != null){
            User userNhanVien = new User(nhanVien.getId(), nhanVien.getTaiKhoan(), nhanVien.getMatKhau(), "ROLE_ADMIN");
            return new CustomUserDetail(userNhanVien);
        }
        else{
            if (khachHang != null) {
                User userKhachHang = new User(khachHang.getId(), khachHang.getTaiKhoan(), khachHang.getMatKhau(), "ROLE_USER");
                return new CustomUserDetail(userKhachHang);
            }
            else {
                throw new UsernameNotFoundException("User not found");
            }
        }
    }

    public UserDetails loadUserById(int id){
        NhanVien nhanVien = nhanVienRepository.getNhanVienById(id);
        KhachHang khachHang = khachHangRepository.getKhachHangById(id);
        if (nhanVien != null){
            User userNhanVien = new User(nhanVien.getId(), nhanVien.getTaiKhoan(), nhanVien.getMatKhau(), "ROLE_ADMIN");
            return new CustomUserDetail(userNhanVien);
        }
        else{
            if (khachHang != null) {
                User userKhachHang = new User(khachHang.getId(), khachHang.getTaiKhoan(), khachHang.getMatKhau(), "ROLE_USER");
                return new CustomUserDetail(userKhachHang);
            }
            else {
                throw new UsernameNotFoundException("User not found with id : " + id);
            }
        }
    }
}
