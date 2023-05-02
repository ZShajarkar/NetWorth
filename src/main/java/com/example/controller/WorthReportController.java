package com.example.controller;

import com.example.dto.WealthDto;
import com.example.service.WealthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("report")
public class WorthReportController {
    private final WealthServiceImpl worthReportService;


    @GetMapping(value = "/net-worth")
    public ResponseEntity<?> calculateNetWorth(@RequestHeader("Authorization") String token) {
        try {
            final WealthDto wealthDto = worthReportService.calculateNetWorth(token);
            return ResponseEntity.ok(wealthDto);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}
