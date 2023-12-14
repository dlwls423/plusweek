package com.sparta.plusweek.domain.post.controller;

import com.sparta.plusweek.domain.post.dto.PostGetAllPostsResList;
import com.sparta.plusweek.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping()
    public ResponseEntity<PostGetAllPostsResList> getAllPosts(){
        PostGetAllPostsResList res = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}
