package com.sparta.plusweek.domain.user.validator;

import com.sparta.plusweek.domain.user.dto.UserSignupReq;
import com.sparta.plusweek.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserValidator {

    public static void validate(User user) {
        if (checkIsNull(user)) {
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
    }

    public static void validate(UserSignupReq req) {
        if (!req.getPassword().equals(req.getConfirmPassword())) {
            throw new IllegalArgumentException("재확인 비밀번호와 일치하지 않습니다.");
        }
    }

    public static void checkIsDuplicatedName(User user) {
        if (user != null) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }
    }

    public static void verifyPassword(PasswordEncoder passwordEncoder, String inputPassword,
        String password) {
        if (!passwordEncoder.matches(inputPassword, password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    private static boolean checkIsNull(User user) {
        return user == null;
    }
}
