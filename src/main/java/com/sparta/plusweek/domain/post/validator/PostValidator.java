package com.sparta.plusweek.domain.post.validator;

import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.user.entity.User;
import java.util.Objects;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PostValidator {

    public static void validate(Post post) {
        if (checkIsNull(post)) {
            throw new IllegalArgumentException("게시글를 찾을 수 없습니다.");
        }
    }

    private static boolean checkIsNull(Post post) {
        return post == null;
    }

    public static void validateUpdateReq(Post post, User user) {
        validate(post);
        if (!Objects.equals(post.getUser().getUsername(), user.getUsername())) {
            throw new IllegalArgumentException("요청자의 게시글이 아닙니다.");
        }
    }
}
