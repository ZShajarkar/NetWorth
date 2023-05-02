package com.example.controller;

import com.example.dto.LiabilityDto;
import com.example.service.LiabilityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("liability")
public class LiabilityController {
    private final LiabilityServiceImpl liabilityService;


    @PostMapping
    public ResponseEntity<?> add(@RequestHeader("Authorization") String token, @RequestBody LiabilityDto liabilityDto) {
        try {
            final LiabilityDto save = liabilityService.save(liabilityDto, token);
            return ResponseEntity.ok(save);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}
