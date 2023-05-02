package com.example.service;

import com.example.dto.AssetDto;

public interface AssetServiceImpl {
    AssetDto save(AssetDto assetDto, String token);
}
