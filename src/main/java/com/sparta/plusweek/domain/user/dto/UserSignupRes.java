package com.sparta.plusweek.domain.user.dto;

import com.sparta.plusweek.domain.user.entity.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserSignupRes {
    private Long id;
    private String username;
    private String email;
    private Role role;

    @Builder
    public UserSignupRes(Long id, String username, String email, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
