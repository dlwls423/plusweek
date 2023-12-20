package com.sparta.plusweek.domain.post.service;

import com.sparta.plusweek.domain.post.dto.PostGetAllRes;
import com.sparta.plusweek.domain.post.dto.PostGetRes;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface PostReadService {

    Page<PostGetAllRes> getAllPosts(int page, int size, String sortBy, boolean isAsc);

    PostGetRes getPost(Long postId);
}
