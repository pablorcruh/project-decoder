package com.ead.authuser.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class JwtDto {

    @NotNull
    private String token;

    private String type = "Bearer";

    public JwtDto(String token) {
        this.token = token;
    }
}
