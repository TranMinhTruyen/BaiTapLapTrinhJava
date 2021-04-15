package com.example.controller;

import com.example.common.entity.ThucAn;
import com.example.service.ThucAnServices;
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
    public ResponseEntity<?> createThucAn(@RequestBody ThucAn thucAn){
        ThucAn dataThucAn = thucAnServices.createThucAn(thucAn);
        if (dataThucAn != null){
            return new ResponseEntity<>(dataThucAn, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateThucAn/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateThucAn(@RequestParam int id, @RequestBody ThucAn thucAn) {
        ThucAn listThucAn = thucAnServices.updateThucAn(id, thucAn);
        if (listThucAn != null)
            return new ResponseEntity<>(listThucAn, HttpStatus.OK);
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
