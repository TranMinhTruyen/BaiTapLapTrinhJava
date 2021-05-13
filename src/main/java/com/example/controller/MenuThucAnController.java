package com.example.controller;

import com.example.common.request.MenuThucAnRequest;
import com.example.services.MenuThucAnServices;
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

@Tag(name = "MenuThucAn")
@RestController
@CrossOrigin("*")
@RequestMapping("api/menuthucan")
public class MenuThucAnController {

    @Autowired
    MenuThucAnServices menuThucAnServices;

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @PostMapping(value = "createMenuThucAn", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createMenu(@RequestBody MenuThucAnRequest menu){
        MenuThucAnRequest menuThucAn = menuThucAnServices.create(menu);
        return new ResponseEntity<>(menuThucAn, HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @GetMapping(value = "getListThucAnByMenuId/")
    public ResponseEntity<?> getListThucAnByMenuId(@RequestParam long idMenu){
        Object dataMenu = menuThucAnServices.getListThucAnByMenuId(idMenu);
        if (dataMenu != null)
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteByIdMenu/")
    public ResponseEntity<?> deleteMenu(@RequestParam int idMenu) {
        boolean dataMenu = menuThucAnServices.deleteByIdMenu(idMenu);
        if (dataMenu)
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteByIdThucAn/")
    public ResponseEntity<?> deleteByIdThucAn(@RequestParam int idThucAn) {
        boolean dataMenu = menuThucAnServices.deleteByIdThucAn(idThucAn);
        if (dataMenu)
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }

    @Operation(responses = @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(hidden = true))))
    @DeleteMapping(value = "deleteThucAnByIdMenu/")
    public ResponseEntity<?> deleteThucAnByIdMenu(@RequestParam long idMenu, @RequestParam int idThucAn) {
        boolean dataMenu = menuThucAnServices.deleteThucAnByIdMenu(idMenu,idThucAn);
        if (dataMenu)
            return new ResponseEntity<>(dataMenu, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found", HttpStatus.OK);
    }
}
