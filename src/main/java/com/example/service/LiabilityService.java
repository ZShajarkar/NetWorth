package com.example.service;

import com.example.dto.LiabilityDto;
import com.example.dto.UserDto;
import com.example.entity.Liability;
import com.example.mapper.LiabilityMapper;
import com.example.repository.LiabilityRepository;
import com.example.repository.UserRepository;
import com.example.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LiabilityService {
    private final LiabilityRepository liabilityRepository;
    private final LiabilityMapper liabilityMapper;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;


    public LiabilityDto save(LiabilityDto liabilityDto, String token) {
        final Long userId = getUserIdFromToken(token);
        UserDto userDto = new UserDto();
        userDto.setId(userId);

        liabilityDto.setUser(userDto);
        final Liability liability = liabilityMapper.toEntity(liabilityDto);
        final Liability save = liabilityRepository.save(liability);
        return liabilityMapper.toDto(save);
    }

    private Long getUserIdFromToken(String token) {
        final String userEmail = jwtTokenUtil.getUsernameFromToken(token);
        final Long userId = userRepository.findByEmail(userEmail).getId();
        return userId;
    }
}
