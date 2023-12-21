package com.sparta.plusweek.domain.post.service.impl;

import com.sparta.plusweek.domain.post.dto.PostCreateReq;
import com.sparta.plusweek.domain.post.dto.PostCreateRes;
import com.sparta.plusweek.domain.post.dto.PostUpdateReq;
import com.sparta.plusweek.domain.post.dto.PostUpdateRes;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.repo.PostRepository;
import com.sparta.plusweek.domain.post.service.PostService;
import com.sparta.plusweek.domain.post.service.PostServiceMapper;
import com.sparta.plusweek.domain.post.validator.PostValidator;
import com.sparta.plusweek.domain.user.entity.User;
import com.sparta.plusweek.infra.s3.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final PostReadServiceImpl postReadService;

    private final S3Util s3Util;

    @Override
    public PostCreateRes createPost(PostCreateReq req, MultipartFile multipartfile, User user) {
        String imageUrl = null;
        if (!multipartfile.isEmpty()) {
            imageUrl = s3Util.uploadImage(multipartfile);
        }

        Post savePost = postRepository.save(Post.builder()
            .title(req.getTitle())
            .content(req.getContent())
            .imageUrl(imageUrl)
            .user(user)
            .build()
        );

        return PostServiceMapper.INSTANCE.toPostCreateRes(savePost);
    }

    @Override
    public PostUpdateRes updatePost(Long postId, PostUpdateReq req, User user) {
        Post post = postReadService.getPostEntity(postId);

        PostValidator.checkPostAuthor(post, user);

        postRepository.save(Post.builder()
            .postId(postId)
            .title(req.getTitle())
            .content(req.getContent())
            .user(user)
            .build()
        );

        return PostServiceMapper.INSTANCE.toPostUpdateRes(postReadService.getPostEntity(postId));
    }

    @Override
    public void deletePost(Long postId, User user) {
        Post post = postReadService.getPostEntity(postId);

        PostValidator.checkPostAuthor(post, user);

        postRepository.delete(post);
    }
}
