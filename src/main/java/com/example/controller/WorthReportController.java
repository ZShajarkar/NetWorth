package com.example.controller;

import com.example.service.WorthReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("report")
public class WorthReportController {
    private final WorthReportService worthReportService;


    @GetMapping(value = "/net-worth")
    public ResponseEntity<?> calculateNetWorth() {
        try {
            final BigDecimal netWorth = worthReportService.calculateNetWorth(1L);
            return ResponseEntity.ok(netWorth);
        } catch (Exception e) {
            return (ResponseEntity<?>) ResponseEntity.badRequest();
        }
    }
}
