package com.sparta.plusweek.infra.mail;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash(value = "auth", timeToLive = 300)
public class AuthEmail {

    @Id
    private String email;

    private String code;

    private boolean isChecked = false;

    @Builder
    private AuthEmail(String email, String code, boolean isChecked) {
        this.email = email;
        this.code = code;
        this.isChecked = isChecked;
    }
}
