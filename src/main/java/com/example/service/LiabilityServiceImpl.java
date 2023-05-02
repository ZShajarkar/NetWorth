package com.example.service;

import com.example.dto.LiabilityDto;

public interface LiabilityServiceImpl {
    LiabilityDto save(LiabilityDto liabilityDto, String token);
}
