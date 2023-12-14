package com.sparta.plusweek.domain.user.dto;

import com.sparta.plusweek.domain.user.entity.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserLoginRes {
    private Long userId;
    private String username;
    private String email;
    private Role role;

    @Builder
    private UserLoginRes(Long userId, String username, String email, Role role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
