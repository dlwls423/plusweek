package com.sparta.plusweek.domain.user.controller;

import com.sparta.plusweek.domain.user.dto.UserConfirmUsernameReq;
import com.sparta.plusweek.domain.user.dto.UserConfirmUsernameRes;
import com.sparta.plusweek.domain.user.dto.UserLoginReq;
import com.sparta.plusweek.domain.user.dto.UserLoginRes;
import com.sparta.plusweek.domain.user.dto.UserSignupReq;
import com.sparta.plusweek.domain.user.dto.UserSignupRes;
import com.sparta.plusweek.domain.user.service.UserService;
import com.sparta.plusweek.global.security.jwt.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

    @PostMapping("/signup/username")
    public ResponseEntity<UserConfirmUsernameRes> confirmUsername(@RequestBody UserConfirmUsernameReq req){
        UserConfirmUsernameRes res = userService.confirmUsername(req);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/signup")
    public ResponseEntity<UserSignupRes> signup(@RequestBody @Valid UserSignupReq req){
        UserSignupRes res = userService.signup(req);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginRes> login(@RequestBody UserLoginReq req, HttpServletResponse response){
        UserLoginRes res = userService.login(req);
        String token = jwtUtil.createToken(req.getUsername());
        addCookie(token, response);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    // 쿠키 읽어오기
//    @GetMapping("/get-cookie")
//    public String getCookie(@CookieValue(AUTHORIZATION_HEADER) String value) {
//        System.out.println("value = " + value);
//
//        return "getCookie : " + value;
//    }

    public static void addCookie(String cookieValue, HttpServletResponse res) {
        try {
            cookieValue = URLEncoder.encode(cookieValue, "utf-8").replaceAll("\\+", "%20"); // Cookie Value 에는 공백이 불가능해서 encoding 진행

            Cookie cookie = new Cookie(JwtUtil.AUTHORIZATION_HEADER, cookieValue); // Name-Value
            cookie.setPath("/");
            cookie.setMaxAge(30 * 60);

            // Response 객체에 Cookie 추가
            res.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
