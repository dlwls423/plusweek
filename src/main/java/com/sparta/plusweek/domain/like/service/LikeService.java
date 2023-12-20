package com.sparta.plusweek.domain.like.service;

import com.sparta.plusweek.domain.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface LikeService {

    void clickLike(Long postId, User user);
}
