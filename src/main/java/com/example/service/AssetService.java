package com.example.service;

import com.example.dto.AssetDto;
import com.example.entity.Asset;
import com.example.mapper.AssetMapper;
import com.example.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {
    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    @Autowired
    public AssetService(AssetRepository assetRepository, AssetMapper assetMapper) {
        this.assetRepository = assetRepository;
        this.assetMapper = assetMapper;
    }


    public AssetDto save(AssetDto assetDto) {
        final Asset asset = assetMapper.toEntity(assetDto);
        final Asset save = assetRepository.save(asset);
        return assetMapper.toDto(save);
    }
}
