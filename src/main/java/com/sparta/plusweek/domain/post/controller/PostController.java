package com.sparta.plusweek.domain.post.controller;

import com.sparta.plusweek.domain.post.dto.PostCreatePostReq;
import com.sparta.plusweek.domain.post.dto.PostCreatePostRes;
import com.sparta.plusweek.domain.post.dto.PostGetAllPostsRes;
import com.sparta.plusweek.domain.post.dto.PostGetPostRes;
import com.sparta.plusweek.domain.post.service.PostReadService;
import com.sparta.plusweek.domain.post.service.PostService;
import com.sparta.plusweek.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostReadService postReadService;

    @GetMapping()
    public ResponseEntity<Page<PostGetAllPostsRes>> getAllPosts(
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestParam("sortBy") String sortBy,
        @RequestParam("isAsc") boolean isAsc
    ) {
        Page<PostGetAllPostsRes> res = postReadService.getAllPosts(page - 1, size, sortBy, isAsc);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostGetPostRes> getPost(
        @PathVariable(name = "postId") Long postId
    ) {
        PostGetPostRes res = postReadService.getPost(postId);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


    @PostMapping()
    public ResponseEntity<PostCreatePostRes> createPost(
        @RequestBody PostCreatePostReq req,
        @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        PostCreatePostRes res = postService.createPost(req, userDetails.getUser());
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


}
