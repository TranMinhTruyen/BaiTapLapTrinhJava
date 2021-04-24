package com.example.controller;

import com.example.common.request.PhanHoiRequest;
import com.example.services.PhanHoiServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "PhanHoi")
@RestController
@CrossOrigin("*")
@RequestMapping("api/phanhoi")
public class PhanHoiController {

    @Autowired
    private PhanHoiServices phanHoiServices;

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createPhanHoi", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPhanHoi(@RequestBody PhanHoiRequest phanHoiRequest){
        PhanHoiRequest dataPhanHoi = phanHoiServices.createPhanHoi(phanHoiRequest);
        if (dataPhanHoi != null){
            return new ResponseEntity<>(dataPhanHoi, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllPhanHoi/")
    public ResponseEntity<?> getAllPhanHoi(@RequestParam int page,
                                        @RequestParam int size){
        Object dataPhanHoi = phanHoiServices.getAllPhanHoi(page, size);
        return new ResponseEntity<>(dataPhanHoi, HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getPhanHoiByKeyword/")
    public ResponseEntity<?> getPhanHoiByKeyword(@RequestParam int page,
                                              @RequestParam int size,
                                              @RequestParam(required = false) String keyword){
        Object dataPhanHoi = phanHoiServices.getPhanHoiByKeyword(page, size, keyword);
        if (dataPhanHoi != null)
            return new ResponseEntity<>(dataPhanHoi, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updatePhanHoi/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePhanHoi(@RequestParam int idTiec,
                                           @RequestParam int idKhachHang,
                                           @RequestBody PhanHoiRequest phanHoiRequest) {
        PhanHoiRequest dataPhanHoi = phanHoiServices.updatePhanHoi(idTiec, idKhachHang, phanHoiRequest);
        if (dataPhanHoi != null)
            return new ResponseEntity<>(dataPhanHoi, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deletePhanHoi/")
    public ResponseEntity<?> deletePhanHoi(@RequestParam int idTiec, @RequestParam int idKhachHang) {
        boolean dataPhanHoi = phanHoiServices.deletePhanHoi(idTiec, idKhachHang);
        if (dataPhanHoi)
            return new ResponseEntity<>(dataPhanHoi, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }
}
