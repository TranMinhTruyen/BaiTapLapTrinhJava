package com.example.controller;

import com.example.common.request.ThucAnRequest;
import com.example.services.ThucAnServices;
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

@Tag(name = "ThucAn")
@RestController
@CrossOrigin("*")
@RequestMapping("api/thucan")
public class ThucAnController {

    @Autowired
    ThucAnServices thucAnServices;

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createThucAn", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createThucAn(@RequestBody ThucAnRequest thucAn){
        ThucAnRequest dataThucAn = thucAnServices.createThucAn(thucAn);
        if (dataThucAn != null){
            return new ResponseEntity<>(dataThucAn, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllThucAn/")
    public ResponseEntity<?> getAllThucAn(@RequestParam int page,
                                          @RequestParam int size){
        Object dataThucAn = thucAnServices.getAllThucAn(page, size);
        return new ResponseEntity<>(dataThucAn, HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getThucAnByKeyword/")
    public ResponseEntity<?> getThucAnByKeyword(@RequestParam int page,
                                                @RequestParam int size,
                                                @RequestParam(required = false) String keyword){
        Object dataThucAn = thucAnServices.getThucAnByKeyword(page, size, keyword);
        if (dataThucAn != null)
            return new ResponseEntity<>(dataThucAn, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateThucAn/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateThucAn(@RequestParam int id, @RequestBody ThucAnRequest thucAn) {
        ThucAnRequest dataThucAn = thucAnServices.updateThucAn(id, thucAn);
        if (dataThucAn != null)
            return new ResponseEntity<>(dataThucAn, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteThucAn/")
    public ResponseEntity<?> deleteThucAn(@RequestParam int id) {
        boolean result = thucAnServices.deleteThucAn(id);
        if (result)
            return new ResponseEntity<>(result, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }
}
