package com.sparta.plusweek.domain.comment.dto;

import com.sparta.plusweek.domain.comment.entity.Comment;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentGetRes {

    private Long commentId;
    private String text;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public CommentGetRes(Comment comment) {
        this.commentId = comment.getCommentId();
        this.text = comment.getText();
        this.username = comment.getUser().getUsername();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
