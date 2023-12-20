package com.sparta.plusweek.domain.like.controller;

import com.sparta.plusweek.domain.like.dto.LikeGetRes;
import com.sparta.plusweek.domain.like.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posts")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @GetMapping("/{postId}/likes")
    public ResponseEntity<LikeGetRes> getPostLike(
        @PathVariable(name = "postId") Long postId
    ) {
        LikeGetRes res = likeService.getLike(postId);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
