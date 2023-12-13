package com.sparta.plusweek.common.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorRes {
    private int statusCode;
    private String message;

    @Builder
    public ErrorRes(HttpStatus status, String message) {
        this.statusCode = status.value();
        this.message = message;
    }
}
