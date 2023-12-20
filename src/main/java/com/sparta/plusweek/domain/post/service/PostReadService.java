package com.sparta.plusweek.domain.post.service;

import com.sparta.plusweek.domain.post.dto.PostGetAllRes;
import com.sparta.plusweek.domain.post.dto.PostGetRes;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.repo.PostRepository;
import com.sparta.plusweek.domain.post.validator.PostValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostReadService {

    private final PostRepository postRepository;

    public Page<PostGetAllRes> getAllPosts(int page, int size, String sortBy, boolean isAsc) {
        // 페이징 처리
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Post> postList = postRepository.findAll(pageable);
        return postList.map(PostServiceMapper.INSTANCE::toPostGetAllRes);
    }

    public PostGetRes getPost(Long postId) {
        Post post = postRepository.findByPostId(postId);
        return PostServiceMapper.INSTANCE.toPostGetRes(post);
    }

    public Post getPostEntity(Long postId) {
        Post post = postRepository.findByPostId(postId);
        PostValidator.validate(post);
        return post;
    }

}
