package com.sparta.plusweek.domain.user.controller;

import com.sparta.plusweek.domain.user.dto.UserLoginReq;
import com.sparta.plusweek.domain.user.dto.UserLoginRes;
import com.sparta.plusweek.domain.user.dto.UserSignupReq;
import com.sparta.plusweek.domain.user.dto.UserSignupRes;
import com.sparta.plusweek.domain.user.service.UserService;
import com.sparta.plusweek.security.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
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
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<UserSignupRes> signup(@RequestBody @Valid UserSignupReq req){
        UserSignupRes res = userService.signup(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginRes> login(@RequestBody UserLoginReq req, HttpServletResponse response){
        UserLoginRes res = userService.login(req);
        response.setHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(req.getUsername()));
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}
