package com.sparta.plusweek.domain.post.validator;

import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.user.dto.UserSignupReq;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostValidator {

    public static void validate(Post post){
        if(checkIsNull(post)){
            throw new IllegalArgumentException("게시글를 찾을 수 없습니다.");
        }
    }

    private static boolean checkIsNull(Post post){
        return post == null;
    }
}
