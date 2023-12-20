package com.sparta.plusweek.domain.comment.dto;

import com.sparta.plusweek.domain.comment.entity.Comment;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CommentCreateRes {

    private Long commentId;
    private Long postId;
    private String text;
    private String username;
    private LocalDateTime createdAt;

    @Builder
    public CommentCreateRes(Comment comment) {
        this.commentId = comment.getCommentId();
        this.postId = comment.getPost().getPostId();
        this.text = comment.getText();
        this.username = comment.getUser().getUsername();
        this.createdAt = comment.getCreatedAt();
    }

}
