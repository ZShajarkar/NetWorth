package com.example.controller;

import com.example.dto.AssetDto;
import com.example.dto.UserDto;
import com.example.repository.UserRepository;
import com.example.service.AssetService;
import com.example.util.JwtTokenUtil;
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
    public ResponseEntity<?> add(@RequestHeader("Authorization") String token, @RequestBody AssetDto assetDto) {
        try {
            final AssetDto save = assetService.save(assetDto, token);
            return ResponseEntity.ok(save);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}
