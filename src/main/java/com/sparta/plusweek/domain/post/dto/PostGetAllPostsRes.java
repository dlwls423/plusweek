package com.sparta.plusweek.domain.post.dto;

import com.sparta.plusweek.domain.post.entity.Post;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostGetAllPostsRes {
    private Long postId;
    private String title;
    private String author;
    private LocalDateTime createdAt;

    @Builder
    public PostGetAllPostsRes(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.author = post.getUser().getUsername();
        this.createdAt = post.getCreatedAt();
    }
}
