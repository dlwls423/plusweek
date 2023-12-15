package com.sparta.plusweek.domain.post.dto;

import com.sparta.plusweek.domain.post.entity.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostCreatePostRes {
    private Long postId;
    private String title;
    private String content;
    private String username;

    @Builder
    public PostCreatePostRes(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.username = post.getUser().getUsername();
    }
}