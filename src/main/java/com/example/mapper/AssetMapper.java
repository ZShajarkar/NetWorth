package com.example.mapper;

import com.example.dto.AssetDto;
import com.example.entity.Asset;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AssetMapper {
    private final ModelMapper modelMapper;

    public AssetMapper() {
        this.modelMapper = new ModelMapper();
    }

    public Asset toEntity(AssetDto assetDto) {
        return modelMapper.map(assetDto, Asset.class);
    }

    public AssetDto toDto(Asset asset) {
        return modelMapper.map(asset, AssetDto.class);
    }
}
