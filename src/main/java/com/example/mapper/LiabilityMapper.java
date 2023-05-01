package com.example.mapper;

import com.example.dto.LiabilityDto;
import com.example.dto.UserDto;
import com.example.entity.Liability;
import com.example.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LiabilityMapper {
    private final ModelMapper modelMapper;

    public LiabilityMapper() {
        this.modelMapper = new ModelMapper();
    }

    public Liability toEntity(LiabilityDto liabilityDto) {
        return modelMapper.map(liabilityDto, Liability.class);
    }

    public LiabilityDto toDto(Liability liability) {
        return modelMapper.map(liability, LiabilityDto.class);
    }
}
