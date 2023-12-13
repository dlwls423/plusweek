package com.sparta.plusweek.common.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponseDto {
    private int statusCode;
    private String message;

    @Builder
    public ErrorResponseDto(HttpStatus status, String message) {
        this.statusCode = status.value();
        this.message = message;
    }
}
