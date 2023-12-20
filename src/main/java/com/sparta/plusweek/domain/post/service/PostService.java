package com.sparta.plusweek.domain.post.service;

import com.sparta.plusweek.domain.post.dto.PostCreateReq;
import com.sparta.plusweek.domain.post.dto.PostCreateRes;
import com.sparta.plusweek.domain.post.dto.PostUpdateReq;
import com.sparta.plusweek.domain.post.dto.PostUpdateRes;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.repo.PostRepository;
import com.sparta.plusweek.domain.post.validator.PostValidator;
import com.sparta.plusweek.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final PostReadService postReadService;

    public PostCreateRes createPost(PostCreateReq req, User user) {
        Post savePost = postRepository.save(Post.builder()
            .title(req.getTitle())
            .content(req.getContent())
            .user(user)
            .build()
        );

        return PostServiceMapper.INSTANCE.toPostCreateRes(savePost);
    }

    public PostUpdateRes updatePost(Long postId, PostUpdateReq req, User user) {
        Post post = postReadService.getPostEntity(postId);

        PostValidator.validateUpdateReq(post, user);

        postRepository.save(Post.builder()
            .postId(postId)
            .title(req.getTitle())
            .content(req.getContent())
            .user(user)
            .build()
        );

        return PostServiceMapper.INSTANCE.toPostUpdateRes(postRepository.findByPostId(postId));
    }

    public void deletePost(Long postId, User user) {
        Post post = postReadService.getPostEntity(postId);

        PostValidator.validateUpdateReq(post, user);

        postRepository.delete(post);
    }
}
