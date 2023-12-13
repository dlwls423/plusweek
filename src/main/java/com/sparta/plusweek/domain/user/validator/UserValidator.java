package com.sparta.plusweek.domain.user.validator;

import com.sparta.plusweek.domain.user.entity.User;

public class UserValidator {
    public static void validate(User user){
        if(checkIsNull(user)){
            throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
        }
    }

    private static boolean checkIsNull(User user){
        return user == null;
    }
}
