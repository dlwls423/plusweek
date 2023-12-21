package com.sparta.plusweek.domain.post.service;

import com.sparta.plusweek.domain.post.dto.PostCreateReq;
import com.sparta.plusweek.domain.post.dto.PostCreateRes;
import com.sparta.plusweek.domain.post.dto.PostUpdateReq;
import com.sparta.plusweek.domain.post.dto.PostUpdateRes;
import com.sparta.plusweek.domain.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface PostService {

    PostCreateRes createPost(PostCreateReq req, MultipartFile multipartfile, User user);

    PostUpdateRes updatePost(Long postId, PostUpdateReq req, User user);

    void deletePost(Long postId, User user);
}
