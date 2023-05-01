package com.example.controller;

import com.example.dto.LiabilityDto;
import com.example.dto.UserDto;
import com.example.service.LiabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("liability")
public class LiabilityController {
    private final LiabilityService liabilityService;

    @Autowired
    public LiabilityController(LiabilityService liabilityService) {
        this.liabilityService = liabilityService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody LiabilityDto liabilityDto) {
        try {
            final UserDto userDto = new UserDto();
            userDto.setId(1L);
            liabilityDto.setUser(userDto);
            final LiabilityDto save = liabilityService.save(liabilityDto);
            return ResponseEntity.ok(save);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}