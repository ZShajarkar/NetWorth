package com.example.service;

import com.example.dto.AssetDto;
import com.example.dto.UserDto;
import com.example.entity.Asset;
import com.example.mapper.AssetMapper;
import com.example.repository.AssetRepository;
import com.example.repository.UserRepository;
import com.example.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetService implements AssetServiceImpl {
    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;


    public AssetDto save(AssetDto assetDto, String token) {
        final Long userId = jwtTokenUtil.getUserIdFromToken(token);
        final UserDto userDto = new UserDto();
        userDto.setId(userId);
        assetDto.setUser(userDto);
        final Asset asset = assetMapper.toEntity(assetDto);
        final Asset save = assetRepository.save(asset);
        return assetMapper.toDto(save);
    }

}
