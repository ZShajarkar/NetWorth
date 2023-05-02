package com.example.service;

import com.example.dto.WealthDto;

public interface WealthServiceImpl {
    WealthDto calculateNetWorth(String token);
}
