package com.example.controller;

import com.example.service.WorthReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("report")
public class WorthReportController {
    private final WorthReportService worthReportService;


    @GetMapping(value = "/net-worth")
    public ResponseEntity<?> calculateNetWorth(@RequestHeader("Authorization") String token) {
        try {
            final BigDecimal netWorth = worthReportService.calculateNetWorth(token.substring(7));
            return ResponseEntity.ok(netWorth);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}
