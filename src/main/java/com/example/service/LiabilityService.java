package com.example.service;

import com.example.dto.LiabilityDto;
import com.example.entity.Liability;
import com.example.mapper.LiabilityMapper;
import com.example.repository.LiabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiabilityService {
    private final LiabilityRepository liabilityRepository;
    private final LiabilityMapper liabilityMapper;

    @Autowired
    public LiabilityService(LiabilityRepository liabilityRepository, LiabilityMapper liabilityMapper) {
        this.liabilityRepository = liabilityRepository;
        this.liabilityMapper = liabilityMapper;
    }


    public LiabilityDto save(LiabilityDto userDto) {
        final Liability liability = liabilityMapper.toEntity(userDto);
        final Liability save = liabilityRepository.save(liability);
        return liabilityMapper.toDto(save);
    }
}
