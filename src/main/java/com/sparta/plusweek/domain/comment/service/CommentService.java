package com.sparta.plusweek.domain.comment.service;

import com.sparta.plusweek.domain.comment.dto.CommentCreateReq;
import com.sparta.plusweek.domain.comment.dto.CommentCreateRes;
import com.sparta.plusweek.domain.comment.entity.Comment;
import com.sparta.plusweek.domain.comment.repo.CommentRepository;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.service.PostReadService;
import com.sparta.plusweek.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    private final PostReadService postReadService;

    public CommentCreateRes createComment(CommentCreateReq req, User user) {

        Post post = postReadService.getPostEntity(req.getPostId());

        Comment saveComment = commentRepository.save(Comment.builder()
            .text(req.getText())
            .user(user)
            .post(post)
            .build()
        );

        return CommentServiceMapper.INSTANCE.toCommentCreateRes(saveComment);
    }
}
