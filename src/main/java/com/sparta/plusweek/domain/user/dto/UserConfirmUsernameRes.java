package com.sparta.plusweek.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserConfirmUsernameRes {
    private boolean duplicated;

    @Builder
    public UserConfirmUsernameRes(boolean duplicated) {
        this.duplicated = duplicated;
    }
}
