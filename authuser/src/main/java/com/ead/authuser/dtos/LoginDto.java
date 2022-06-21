package com.ead.authuser.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {

    @NotBlank
    public String username;

    @NotBlank
    public String password;
}
