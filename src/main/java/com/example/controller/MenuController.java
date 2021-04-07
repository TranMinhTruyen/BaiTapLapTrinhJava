package com.example.controller;

import com.example.common.entity.Menu;
import com.example.service.MenuServices;
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

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Menu")
@RestController
@CrossOrigin("*")
@RequestMapping("api/menu")
public class MenuController {

    @Autowired
    private MenuServices menuServices;


    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createMenu", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createMenu(@RequestBody Menu menu){
        Menu dataMenu = menuServices.createMenu(menu);
        if (dataMenu != null){
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Not found TiecID or ThucAnID", HttpStatus.OK);
    }


    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getMenuByKeyword/")
    public ResponseEntity<?> getMenuByKeyword(@RequestParam() int page,
                                              @RequestParam() int size,
                                              @RequestParam() int keyword){
        Object dataMenu = menuServices.getMenuCuaTiec(page, size, keyword);
        return new ResponseEntity<>(dataMenu, HttpStatus.OK);
    }


    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateSoLuong/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSoLuong(@RequestParam int idTiec,
                                           @RequestParam int idThucAn,
                                           @RequestBody Menu menu) {
        Menu dataMenu = menuServices.updateSoLuong(idTiec, idThucAn, menu);
        if (dataMenu != null)
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }


    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteThucAn/")
    public ResponseEntity<?> deleteThucAn(@RequestParam int idTiec,
                                          @RequestParam int idThucAn) {
        boolean dataMenu = menuServices.deleteThucAn(idTiec, idThucAn);
        if (dataMenu)
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }


    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteMenu/")
    public ResponseEntity<?> deleteMenu(@RequestParam int idTiec) {
        boolean dataMenu = menuServices.deleteMenu(idTiec);
        if (dataMenu)
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }
}
