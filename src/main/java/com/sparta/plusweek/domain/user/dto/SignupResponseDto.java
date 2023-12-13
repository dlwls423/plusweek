package com.sparta.plusweek.domain.user.dto;

import com.sparta.plusweek.domain.user.entity.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupResponseDto {
    private Long id;
    private String username;
    private String email;
    private Role role;
}
