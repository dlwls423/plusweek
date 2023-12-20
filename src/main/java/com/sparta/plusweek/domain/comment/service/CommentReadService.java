package com.sparta.plusweek.domain.comment.service;

import com.sparta.plusweek.domain.comment.repo.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentReadService {

    private final CommentRepository commentRepository;


}
