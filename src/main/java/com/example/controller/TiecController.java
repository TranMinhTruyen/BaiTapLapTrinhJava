package com.example.controller;

import com.example.common.entity.Tiec;
import com.example.service.TiecServices;
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

@Tag(name = "Tiec")
@RestController
@CrossOrigin("*")
@RequestMapping("api/tiec")
public class TiecController {
    @Autowired
    TiecServices tiecServices;

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createTiec", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTiec(@RequestBody Tiec tiec){
        Tiec result = tiecServices.creatTiec(tiec);
        if (result != null){
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getTiecByKeyword/")
    public ResponseEntity<?> getTiecByKeyword(@RequestParam int page,
                                                @RequestParam int size,
                                                @RequestParam(required = false) String keyword){
        Object result = tiecServices.getTiecByKeyword(page, size, keyword);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateTiec/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTiec(@RequestParam int id, @RequestBody Tiec tiec) {
        Tiec result = tiecServices.updateTiec(id, tiec);
        if (result != null)
            return new ResponseEntity<>(result, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteTiec/")
    public ResponseEntity<?> deleteTiec(@RequestParam int id) {
        boolean result = tiecServices.deleteTiec(id);
        if (result)
            return new ResponseEntity<>(result, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }
}
