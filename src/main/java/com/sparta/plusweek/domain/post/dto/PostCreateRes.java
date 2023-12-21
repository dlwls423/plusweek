package com.sparta.plusweek.domain.post.dto;

import com.sparta.plusweek.domain.post.entity.Post;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostCreateRes {

    private Long postId;
    private String title;
    private String content;
    private String imageUrl;
    private String username;
    private LocalDateTime createdAt;

    @Builder
    public PostCreateRes(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.imageUrl = post.getImageUrl();
        this.username = post.getUser().getUsername();
        this.createdAt = post.getCreatedAt();
    }
}
