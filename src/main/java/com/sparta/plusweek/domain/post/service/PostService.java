package com.sparta.plusweek.domain.post.service;

import com.sparta.plusweek.domain.post.dto.PostGetAllPostsRes;
import com.sparta.plusweek.domain.post.dto.PostGetAllPostsResList;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.repo.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostGetAllPostsResList getAllPosts() {
        List<Post> postList = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostGetAllPostsRes> resList =  PostServiceMapper.INSTANCE.toPostGetAllPostsListRes(postList);
        return new PostGetAllPostsResList(resList);
    }
}
