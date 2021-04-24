package com.example.controller;

import com.example.common.request.CaLamViecRequest;
import com.example.services.CaLamViecServices;
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

@Tag(name = "CaLamViec")
@RestController
@CrossOrigin("*")
@RequestMapping("api/calamviec")
public class CaLamViecController {

    @Autowired
    private CaLamViecServices caLamViecServices;

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createCaLamViec", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createCaLamViec(@RequestBody CaLamViecRequest caLamViecRequest){
        CaLamViecRequest dataCaLamViec= caLamViecServices.createCaLamViec(caLamViecRequest);
        if (dataCaLamViec != null){
            return new ResponseEntity<>(dataCaLamViec, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getCaLamViecByKeyword/")
    public ResponseEntity<?> getCaLamViecByKeyword(@RequestParam int page,
                                                   @RequestParam int size,
                                                   @RequestParam(required = false) String keyword){
        Object dataCaLamViec = caLamViecServices.getCaLamViecByKeyword(page, size, keyword);
        return new ResponseEntity<>(dataCaLamViec, HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateCaLamViec/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCaLamViec(@RequestParam int id, @RequestBody CaLamViecRequest caLamViecRequest) {
        CaLamViecRequest dataCaLamViec = caLamViecServices.updateCaLamViec(id, caLamViecRequest);
        if (dataCaLamViec != null)
            return new ResponseEntity<>(dataCaLamViec, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteCaLamViec/")
    public ResponseEntity<?> deleteCaLamViec(@RequestParam int id) {
        boolean dataCaLamViec = caLamViecServices.deleteCaLamViec(id);
        if (dataCaLamViec)
            return new ResponseEntity<>(dataCaLamViec, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllCaLamViec/")
    public ResponseEntity<?> getAllCaLamViec(@RequestParam int page,
                                             @RequestParam int size){
        Object dataCaLamViec = caLamViecServices.getAllCaLamViec(page, size);
        return new ResponseEntity<>(dataCaLamViec, HttpStatus.OK);
    }
}
