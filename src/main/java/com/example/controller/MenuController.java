package com.example.controller;

import com.example.common.request.MenuRequest;
import com.example.services.MenuServices;
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

@Tag(name = "Menu")
@RestController
@CrossOrigin("*")
@RequestMapping("api/menu")
public class MenuController {

    @Autowired
    private MenuServices menuServices;


    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createMenu", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createMenu(@RequestBody MenuRequest menu){
        MenuRequest dataMenu = menuServices.createMenu(menu);
        if (dataMenu != null){
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getAllMenu/")
    public ResponseEntity<?> getAllMenu(@RequestParam int page,
                                        @RequestParam int size){
        Object dataMenu = menuServices.getAllMenu(page, size);
        return new ResponseEntity<>(dataMenu, HttpStatus.OK);
    }


    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getMenuByKeyword/")
    public ResponseEntity<?> getMenuByKeyword(@RequestParam int page,
                                              @RequestParam int size,
                                              @RequestParam(required = false) String keyword){
        Object dataMenu = menuServices.getMenuByKeyword(page, size, keyword);
        if (dataMenu != null)
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }


    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PutMapping(value = "updateMenu/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateMenu(@RequestParam int idMenu, @RequestBody MenuRequest menu) {
        MenuRequest dataMenu = menuServices.updateMenu(idMenu, menu);
        if (dataMenu != null)
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteMenu/")
    public ResponseEntity<?> deleteMenu(@RequestParam int idMenu) {
        boolean dataMenu = menuServices.deleteMenu(idMenu);
        if (dataMenu)
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }
}
