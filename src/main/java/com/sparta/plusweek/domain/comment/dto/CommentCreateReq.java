package com.sparta.plusweek.domain.comment.dto;

import lombok.Getter;

@Getter
public class CommentCreateReq {

    private Long postId;

    private String text;

}
