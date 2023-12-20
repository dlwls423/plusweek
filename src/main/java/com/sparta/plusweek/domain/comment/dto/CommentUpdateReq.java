package com.sparta.plusweek.domain.comment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentUpdateReq {

    @NotBlank
    private Long postId;

    @NotBlank
    private String text;
}
