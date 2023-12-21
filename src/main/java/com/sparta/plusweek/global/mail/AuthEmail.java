package com.sparta.plusweek.global.mail;

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

    @Builder
    private AuthEmail(String email, String code) {
        this.email = email;
        this.code = code;
    }
}
