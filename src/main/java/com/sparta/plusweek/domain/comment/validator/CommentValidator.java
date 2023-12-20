package com.sparta.plusweek.domain.comment.validator;

import com.sparta.plusweek.domain.comment.entity.Comment;

public class CommentValidator {

    public static void validate(Comment comment) {
        if (checkIsNull(comment)) {
            throw new IllegalArgumentException("댓글을 찾을 수 없습니다.");
        }
    }

    private static boolean checkIsNull(Comment comment) {
        return comment == null;
    }

}
