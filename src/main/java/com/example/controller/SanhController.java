package com.example.controller;

import com.example.entity.Sanh;
import com.example.service.SanhServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Sanh")
@RestController
@CrossOrigin("*")
@RequestMapping("api/sanh")
public class SanhController {

    @Autowired
    private SanhServices sanhServices;

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createSanh", consumes = {"application/json"})
    public ResponseEntity<?> createSanh(@RequestBody Sanh sanh){
        Sanh dataSanh = sanhServices.createSanh(sanh);
        if (dataSanh != null){
            return new ResponseEntity<>(dataSanh, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllSanh")
    public ResponseEntity<List<Sanh>> getAllSanh(){
        List<Sanh> listKhoa = sanhServices.getAllSanh();
        return new ResponseEntity<>(listKhoa, HttpStatus.OK);
    }
}
