package com.sparta.plusweek.domain.comment.controller;

import com.sparta.plusweek.domain.comment.dto.CommentCreateReq;
import com.sparta.plusweek.domain.comment.dto.CommentCreateRes;
import com.sparta.plusweek.domain.comment.service.CommentReadService;
import com.sparta.plusweek.domain.comment.service.CommentService;
import com.sparta.plusweek.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final CommentReadService commentReadService;

    @PostMapping()
    public ResponseEntity<CommentCreateRes> createComment(
        @RequestBody CommentCreateReq req,
        @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        CommentCreateRes res = commentService.createComment(req, userDetails.getUser());
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
