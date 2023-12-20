package com.sparta.plusweek.domain.comment.service;

import com.sparta.plusweek.domain.comment.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentReadService {

    Comment getCommentEntity(Long commentId);
}
