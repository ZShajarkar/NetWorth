package com.example.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String name;
    @NotNull(message = "email is mandatory")
    @NotEmpty(message = "email is mandatory")
    @Email
    private String email;
    @NotNull(message = "password is mandatory")
    @NotEmpty(message = "password is mandatory")
    private String passWord;
}
