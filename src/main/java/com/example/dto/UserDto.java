package com.example.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String passWord;
}
