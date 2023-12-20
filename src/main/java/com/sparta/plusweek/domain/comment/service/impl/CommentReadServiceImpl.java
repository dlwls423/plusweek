package com.sparta.plusweek.domain.comment.service.impl;

import com.sparta.plusweek.domain.comment.repo.CommentRepository;
import com.sparta.plusweek.domain.comment.service.CommentReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentReadServiceImpl implements CommentReadService {

    private final CommentRepository commentRepository;


}
