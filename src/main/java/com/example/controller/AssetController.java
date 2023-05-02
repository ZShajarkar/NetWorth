package com.example.controller;

import com.example.dto.AssetDto;
import com.example.dto.UserDto;
import com.example.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("asset")
public class AssetController {
    private final AssetService assetService;


    @PostMapping
    public ResponseEntity<?> add(@RequestBody AssetDto assetDto) {
        try {
            final UserDto userDto = new UserDto();
            userDto.setId(1L);
            assetDto.setUser(userDto);
            final AssetDto save = assetService.save(assetDto);
            return ResponseEntity.ok(save);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}
