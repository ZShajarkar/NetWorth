package com.example.controller;

import com.example.dto.LiabilityDto;
import com.example.dto.UserDto;
import com.example.service.LiabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("liability")
public class LiabilityController {
    private final LiabilityService liabilityService;


    @PostMapping
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
