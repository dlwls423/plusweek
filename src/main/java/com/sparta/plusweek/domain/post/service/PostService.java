package com.sparta.plusweek.domain.post.service;

import com.sparta.plusweek.domain.post.dto.PostCreatePostReq;
import com.sparta.plusweek.domain.post.dto.PostCreatePostRes;
import com.sparta.plusweek.domain.post.dto.PostGetAllPostsRes;
import com.sparta.plusweek.domain.post.dto.PostGetAllPostsResList;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.repo.PostRepository;
import com.sparta.plusweek.domain.user.entity.User;
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
