package com.example.controller;

import com.example.service.MenuServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Menu")
@RestController
@CrossOrigin("*")
@RequestMapping("api/menu")
public class MenuController {

    @Autowired
    private MenuServices menuServices;

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getSanhByKeyword/")
    public ResponseEntity<?> getSanhByKeyword(@RequestParam(required = false) int keyword){
        Object listSanh = menuServices.getMenuCuaTiec(keyword);
        return new ResponseEntity<>(listSanh, HttpStatus.OK);
    }
}
