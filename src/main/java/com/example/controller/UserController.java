package com.example.controller;

import com.example.dto.UserDto;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody UserDto userDto) {
        try {
            final UserDto save = userService.save(userDto);
            return ResponseEntity.ok(save);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}
