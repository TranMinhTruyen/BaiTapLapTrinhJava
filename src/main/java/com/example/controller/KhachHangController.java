package com.example.controller;

import com.example.common.entity.KhachHang;
import com.example.common.jwt.JWTTokenProvider;
import com.example.common.request.KhachHangRequest;
import com.example.common.request.LoginRequest;
import com.example.common.response.JwtResponse;
import com.example.common.response.KhachHangResponse;
import com.example.common.response.NhanVienResponse;
import com.example.common.user.CustomUserDetail;
import com.example.common.user.User;
import com.example.services.KhachHangServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Tag(name = "KhachHang")
@RestController
@CrossOrigin("*")
@RequestMapping("api/khachhang")
public class KhachHangController {
    @Autowired
    KhachHangServices khachHangServices;

    @Autowired
    JWTTokenProvider jwtTokenProvider;

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createKhachHang", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createKhachHang(@RequestBody KhachHangRequest khachHangRequest){
        KhachHangRequest dataKhachHang= khachHangServices.createKhachHang(khachHangRequest);
        if (dataKhachHang != null){
            return new ResponseEntity<>(dataKhachHang, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getKhachHangByKeyword/")
    public ResponseEntity<?> getKhachHangByKeyword(@RequestParam int page,
                                                   @RequestParam int size,
                                                   @RequestParam(required = false) String keyword){
        Object dataKhachHang = khachHangServices.getKhachHangByKeyword(page, size, keyword);
        return new ResponseEntity<>(dataKhachHang, HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateKhachHang/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateKhachHang(@RequestParam int id, @RequestBody KhachHangRequest khachHangRequest) {
        KhachHangRequest dataKhachHang = khachHangServices.updateKhachHangById(id, khachHangRequest);
        if (dataKhachHang != null)
            return new ResponseEntity<>(dataKhachHang, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteKhachHang/")
    public ResponseEntity<?> deleteKhachHang(@RequestParam int id) {
        boolean dataKhachHang = khachHangServices.deleteKhachHangById(id);
        if (dataKhachHang)
            return new ResponseEntity<>(dataKhachHang, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllKhachHang/")
    public ResponseEntity<?> getAllKhachHang(@RequestParam int page,
                                        @RequestParam int size){
        Object dataKhachHang = khachHangServices.getAllKhachHang(page, size);
        return new ResponseEntity<>(dataKhachHang, HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "loginKhachHang/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity loginKhachHang(@RequestBody LoginRequest loginRequest){
        KhachHangResponse dataKhachHang = khachHangServices.getKhachHangByTaiKhoanMatKhau(loginRequest);
        if (dataKhachHang != null){
            User user = new User(dataKhachHang.getId(), loginRequest.getTaiKhoan(), loginRequest.getMatKhau(), "USER");
            CustomUserDetail customUserDetail = new CustomUserDetail(user);
            String jwt = jwtTokenProvider.generateToken(customUserDetail);
            JwtResponse jwtResponse = new JwtResponse(jwt);
            return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
        }
        else return new ResponseEntity<>("Not found khach hang account", HttpStatus.OK);
    }
}
