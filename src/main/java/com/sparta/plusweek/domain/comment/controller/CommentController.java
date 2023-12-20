package com.sparta.plusweek.domain.comment.controller;

import com.sparta.plusweek.domain.comment.dto.CommentCreateReq;
import com.sparta.plusweek.domain.comment.dto.CommentCreateRes;
import com.sparta.plusweek.domain.comment.dto.CommentUpdateReq;
import com.sparta.plusweek.domain.comment.dto.CommentUpdateRes;
import com.sparta.plusweek.domain.comment.service.impl.CommentServiceImpl;
import com.sparta.plusweek.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentServiceImpl commentService;

    @PostMapping()
    public ResponseEntity<CommentCreateRes> createComment(
        @RequestBody CommentCreateReq req,
        @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        CommentCreateRes res = commentService.createComment(req, userDetails.getUser());
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentUpdateRes> updateComment(
        @PathVariable(name = "commentId") Long commentId,
        @RequestBody CommentUpdateReq req,
        @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        CommentUpdateRes res = commentService.updateComment(commentId, req, userDetails.getUser());
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> updateComment(
        @PathVariable(name = "commentId") Long commentId,
        @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        commentService.deleteComment(commentId, userDetails.getUser());
        return ResponseEntity.noContent().build();
    }
}
