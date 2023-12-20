package com.sparta.plusweek.domain.post.dto;

import com.sparta.plusweek.domain.post.entity.Post;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostGetAllRes {

    private Long postId;
    private String title;
    private String username;
    private LocalDateTime createdAt;

    @Builder
    public PostGetAllRes(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.username = post.getUser().getUsername();
        this.createdAt = post.getCreatedAt();
    }
}
