package com.sparta.plusweek.domain.like.service;

import com.sparta.plusweek.domain.like.dto.LikeGetRes;
import org.springframework.stereotype.Service;

@Service
public interface LikeReadService {

    LikeGetRes getLike(Long postId);
}
