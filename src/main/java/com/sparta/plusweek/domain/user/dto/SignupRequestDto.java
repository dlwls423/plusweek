package com.sparta.plusweek.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignupRequestDto {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{3,15}$")
    private String username;

    @NotBlank
    @Size(min = 4, max = 20)
    private String password;

    @NotBlank
    private String confirmPassword;

    @NotBlank
    @Email
    private String email;

}
