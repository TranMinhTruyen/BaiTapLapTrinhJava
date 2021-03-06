package com.example.controller;

import com.example.common.jwt.JWTTokenProvider;
import com.example.common.request.LoginRequest;
import com.example.common.request.NhanVienRequest;
import com.example.common.response.JwtResponse;
import com.example.common.response.NhanVienResponse;
import com.example.common.user.CustomUserDetail;
import com.example.common.user.User;
import com.example.services.NhanVienServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Tag(name = "NhanVien")
@RestController
@CrossOrigin("*")
@RequestMapping("api/nhanvien")
public class NhanVienController {

    @Autowired
    NhanVienServices nhanVienServices;

    @Autowired
    JWTTokenProvider jwtTokenProvider;

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createNhanVien", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNhanVien(@RequestBody NhanVienRequest nhanVienRequest){
        NhanVienRequest dataNhanVien= nhanVienServices.createNhanVien(nhanVienRequest);
        if (dataNhanVien != null){
            return new ResponseEntity<>(dataNhanVien, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getNhanVienByKeyword/")
    public ResponseEntity<?> getNhanVienByKeyword(@RequestParam int page,
                                                   @RequestParam int size,
                                                   @RequestParam(required = false) String keyword){
        Object dataNhanVien = nhanVienServices.getNhanVienByKeyword(page, size, keyword);
        return new ResponseEntity<>(dataNhanVien, HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateNhanVien/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateNhanVien(@RequestParam int id, @RequestBody NhanVienRequest nhanVienRequest) {
        NhanVienRequest dataNhanVien = nhanVienServices.updateNhanVienById(id, nhanVienRequest);
        if (dataNhanVien != null)
            return new ResponseEntity<>(dataNhanVien, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteNhanVien/")
    public ResponseEntity<?> deleteNhanVien(@RequestParam int id) {
        boolean dataNhanVien = nhanVienServices.deleteNhanVienById(id);
        if (dataNhanVien)
            return new ResponseEntity<>(dataNhanVien, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllNhanVien/")
    public ResponseEntity<?> getAllNhanVien(@RequestParam int page, @RequestParam int size){
        Object dataNhanVien = nhanVienServices.getAllNhanVien(page, size);
        return new ResponseEntity<>(dataNhanVien, HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "loginNhanVien", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> loginNhanVien(@RequestBody LoginRequest loginRequest){
        NhanVienResponse dataNhanVien = nhanVienServices.getNhanVienByTaiKhoanMatKhau(loginRequest);
        if (dataNhanVien != null){
            User user = new User(dataNhanVien.getId(), loginRequest.getTaiKhoan(), loginRequest.getMatKhau(), "ADMIN");
            CustomUserDetail customUserDetail = new CustomUserDetail(user);
            String jwt = jwtTokenProvider.generateToken(customUserDetail);
            JwtResponse jwtResponse = new JwtResponse(jwt);
            return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
        }
        else return new ResponseEntity<>("Not found khach hang account", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "/logout")
    public ResponseEntity<?> logoutNhanVien(HttpServletRequest request){
        HttpSession session= request.getSession(false);
        SecurityContextHolder.clearContext();
        session= request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return new ResponseEntity<>("true", HttpStatus.OK);
    }
}
