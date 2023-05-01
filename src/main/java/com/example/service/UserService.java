package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto save(UserDto userDto) {
        final User user = userMapper.toEntity(userDto);
        final User save = userRepository.save(user);
        return userMapper.toDto(save);
    }
}
