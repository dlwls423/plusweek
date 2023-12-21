package com.sparta.plusweek.domain.like.service.impl;

import com.sparta.plusweek.domain.like.dto.LikeGetRes;
import com.sparta.plusweek.domain.like.entity.Like;
import com.sparta.plusweek.domain.like.repo.LikeRepository;
import com.sparta.plusweek.domain.like.service.LikeReadService;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.service.PostReadService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeReadServiceImpl implements LikeReadService {

    private final LikeRepository likeRepository;

    private final PostReadService postReadService;

    public LikeGetRes getLike(Long postId) {
        Post post = postReadService.getPostEntity(postId);

        List<Like> likeList = likeRepository.findAllByPost(post);

        return new LikeGetRes(postId, likeList.size());
    }
}
