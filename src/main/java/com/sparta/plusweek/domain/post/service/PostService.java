package com.sparta.plusweek.domain.post.service;

import com.sparta.plusweek.domain.post.dto.PostCreatePostReq;
import com.sparta.plusweek.domain.post.dto.PostCreatePostRes;
import com.sparta.plusweek.domain.post.dto.PostUpdatePostReq;
import com.sparta.plusweek.domain.post.dto.PostUpdatePostRes;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.repo.PostRepository;
import com.sparta.plusweek.domain.post.validator.PostValidator;
import com.sparta.plusweek.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostCreatePostRes createPost(PostCreatePostReq req, User user) {
        Post savePost = postRepository.save(Post.builder()
            .title(req.getTitle())
            .content(req.getContent())
            .user(user)
            .build()
        );

        return PostServiceMapper.INSTANCE.toPostCreatePostRes(savePost);
    }

    @Transactional
    public PostUpdatePostRes updatePost(Long postId, PostUpdatePostReq req, User user) {
        Post post = postRepository.findByPostId(postId);

        PostValidator.validateUpdateReq(post, user);

        Post savePost = postRepository.save(Post.builder()
            .postId(postId)
            .title(req.getTitle())
            .content(req.getContent())
            .user(user)
            .build()
        );

        return PostServiceMapper.INSTANCE.toPostUpdatePostRes(savePost);
    }
}
