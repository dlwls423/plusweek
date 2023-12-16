package com.sparta.plusweek.domain.post.service;

import com.sparta.plusweek.domain.post.dto.PostCreatePostReq;
import com.sparta.plusweek.domain.post.dto.PostCreatePostRes;
import com.sparta.plusweek.domain.post.dto.PostGetAllPostsRes;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.repo.PostRepository;
import com.sparta.plusweek.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Page<PostGetAllPostsRes> getAllPosts(int page, int size, String sortBy, boolean isAsc) {
        // 페이징 처리
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Post> postList = postRepository.findAll(pageable);
        return postList.map(PostServiceMapper.INSTANCE::toPostGetAllPostsRes);
    }

    public PostCreatePostRes createPost(PostCreatePostReq req, User user) {
        Post savePost = postRepository.save(Post.builder()
            .title(req.getTitle())
            .content(req.getContent())
            .user(user)
            .build()
        );

        return PostServiceMapper.INSTANCE.toPostCreatePostRes(savePost);
    }
}
