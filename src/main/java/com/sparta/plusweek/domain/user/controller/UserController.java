package com.sparta.plusweek.domain.user.controller;

import com.sparta.plusweek.domain.user.dto.SignupRequestDto;
import com.sparta.plusweek.domain.user.dto.SignupResponseDto;
import com.sparta.plusweek.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody @Valid SignupRequestDto signupRequestDto){
        SignupResponseDto responseDto = userService.signup(signupRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

}
