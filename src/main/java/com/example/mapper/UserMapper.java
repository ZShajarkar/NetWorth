package com.example.mapper;

import com.example.dto.UserDto;
import com.example.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper() {
        this.modelMapper = new ModelMapper();
    }

    public User toEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
