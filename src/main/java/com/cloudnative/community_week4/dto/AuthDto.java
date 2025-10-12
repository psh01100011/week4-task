package com.cloudnative.community_week4.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthDto {
    private String email;
    private String password;
}
