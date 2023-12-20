package com.sparta.plusweek.domain.like.validator;

import com.sparta.plusweek.domain.like.entity.Like;

public class LikeValidator {

    private static boolean checkIsNull(Like like) {
        return like == null;
    }
}
