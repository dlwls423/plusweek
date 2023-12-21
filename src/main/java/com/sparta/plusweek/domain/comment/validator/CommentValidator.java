package com.sparta.plusweek.domain.comment.validator;

import com.sparta.plusweek.domain.comment.entity.Comment;
import com.sparta.plusweek.domain.user.entity.User;

public class CommentValidator {

    public static void validate(Comment comment) {
        if (checkIsNull(comment)) {
            throw new IllegalArgumentException("댓글을 찾을 수 없습니다.");
        }
    }

    public static void checkCommentAuthor(Comment comment, User user) {
        if (!comment.getUser().getUsername().equals(user.getUsername())) {
            throw new IllegalArgumentException("작성자만 수정 및 삭제할 수 있습니다.");
        }
    }

    private static boolean checkIsNull(Comment comment) {
        return comment == null;
    }

}
