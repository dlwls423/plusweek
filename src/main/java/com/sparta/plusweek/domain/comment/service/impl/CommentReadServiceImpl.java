package com.sparta.plusweek.domain.comment.service.impl;

import com.sparta.plusweek.domain.comment.entity.Comment;
import com.sparta.plusweek.domain.comment.repo.CommentRepository;
import com.sparta.plusweek.domain.comment.service.CommentReadService;
import com.sparta.plusweek.domain.comment.validator.CommentValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentReadServiceImpl implements CommentReadService {

    private final CommentRepository commentRepository;

    @Override
    public Comment getCommentEntity(Long commentId) {
        Comment comment = commentRepository.findByCommentId(commentId);
        CommentValidator.validate(comment);
        return comment;
    }
}
