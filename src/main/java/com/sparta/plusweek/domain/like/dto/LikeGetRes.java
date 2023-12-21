package com.sparta.plusweek.domain.like.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LikeGetRes {

    private Long postId;

    private int likes;

    @Builder
    public LikeGetRes(Long postId, int likes) {
        this.postId = postId;
        this.likes = likes;
    }
}
