package com.sparta.plusweek.domain.like.service.impl;

import com.sparta.plusweek.domain.like.entity.Like;
import com.sparta.plusweek.domain.like.repo.LikeRepository;
import com.sparta.plusweek.domain.like.service.LikeService;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.service.PostReadService;
import com.sparta.plusweek.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    private final PostReadService postReadService;

    @Override
    public void clickLike(Long postId, User user) {
        Post post = postReadService.getPostEntity(postId);
        Like like = likeRepository.findByPostAndUser(post, user);

        if (like == null) {
            likeRepository.save(Like.builder().user(user).post(post).build());
        } else {
            likeRepository.delete(like);
        }
    }
}
