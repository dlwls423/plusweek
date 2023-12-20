package com.sparta.plusweek.domain.post.dto;

import com.sparta.plusweek.domain.comment.dto.CommentGetRes;
import com.sparta.plusweek.domain.comment.service.CommentServiceMapper;
import com.sparta.plusweek.domain.post.entity.Post;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostGetRes {

    private Long postId;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<CommentGetRes> commentList;

    @Builder
    public PostGetRes(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.username = post.getUser().getUsername();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.commentList = post.getComments().stream()
            .map(CommentServiceMapper.INSTANCE::toCommentGetRes).toList();
    }
}
