package com.example.controller;

import com.example.common.request.SanhRequest;
import com.example.services.SanhServices;
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


@Tag(name = "Sanh")
@RestController
@CrossOrigin("*")
@RequestMapping("api/sanh")
public class SanhController {

    @Autowired
    private SanhServices sanhServices;

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createSanh", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createSanh(@RequestBody SanhRequest sanh){
        SanhRequest dataSanh = sanhServices.createSanh(sanh);
        if (dataSanh != null){
            return new ResponseEntity<>(dataSanh, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getSanhByKeyword/")
    public ResponseEntity<?> getSanhByKeyword(@RequestParam int page,
                                              @RequestParam int size,
                                              @RequestParam(required = false) String keyword){
        Object listSanh = sanhServices.getSanhByKeyword(page, size, keyword);
        return new ResponseEntity<>(listSanh, HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateSanh/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSanh(@RequestParam int id, @RequestBody SanhRequest sanh) {
        SanhRequest dataSanh = sanhServices.updateSanh(id, sanh);
        if (dataSanh != null)
            return new ResponseEntity<>(dataSanh, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteSanh/")
    public ResponseEntity<?> deleteSanh(@RequestParam int id) {
        boolean dataSanh = sanhServices.deleteSanhById(id);
        if (dataSanh)
            return new ResponseEntity<>(dataSanh, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllSanh/")
    public ResponseEntity<?> getAllSanh(@RequestParam int page,
                                        @RequestParam int size){
        Object dataSanh = sanhServices.getAllSanh(page, size);
        return new ResponseEntity<>(dataSanh, HttpStatus.OK);
    }
}
