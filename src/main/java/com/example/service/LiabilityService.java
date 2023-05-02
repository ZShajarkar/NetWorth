package com.example.service;

import com.example.dto.LiabilityDto;
import com.example.dto.UserDto;
import com.example.entity.Liability;
import com.example.mapper.LiabilityMapper;
import com.example.repository.LiabilityRepository;
import com.example.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LiabilityService implements LiabilityServiceImpl {
    private final LiabilityRepository liabilityRepository;
    private final LiabilityMapper liabilityMapper;
    private final JwtTokenUtil jwtTokenUtil;


    public LiabilityDto save(LiabilityDto liabilityDto, String token) {
        final Long userId = jwtTokenUtil.getUserIdFromToken(token);
        UserDto userDto = new UserDto();
        userDto.setId(userId);
        liabilityDto.setUser(userDto);

        final Liability liability = liabilityMapper.toEntity(liabilityDto);
        final Liability save = liabilityRepository.save(liability);
        return liabilityMapper.toDto(save);
    }

}
