package com.sparta.plusweek.domain.comment.service.impl;

import com.sparta.plusweek.domain.comment.dto.CommentCreateReq;
import com.sparta.plusweek.domain.comment.dto.CommentCreateRes;
import com.sparta.plusweek.domain.comment.dto.CommentUpdateReq;
import com.sparta.plusweek.domain.comment.dto.CommentUpdateRes;
import com.sparta.plusweek.domain.comment.entity.Comment;
import com.sparta.plusweek.domain.comment.repo.CommentRepository;
import com.sparta.plusweek.domain.comment.service.CommentReadService;
import com.sparta.plusweek.domain.comment.service.CommentService;
import com.sparta.plusweek.domain.comment.service.CommentServiceMapper;
import com.sparta.plusweek.domain.comment.validator.CommentValidator;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.service.Impl.PostReadServiceImpl;
import com.sparta.plusweek.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final CommentReadService commentReadService;

    private final PostReadServiceImpl postReadService;

    @Override
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

    @Override
    public CommentUpdateRes updateComment(Long commentId, CommentUpdateReq req, User user) {
        Post post = postReadService.getPostEntity(req.getPostId());
        Comment comment = commentReadService.getCommentEntity(commentId);

        CommentValidator.checkCommentAuthor(comment, user);

        commentRepository.save(Comment.builder()
            .commentId(commentId)
            .text(req.getText())
            .user(user)
            .post(post)
            .build()
        );

        return CommentServiceMapper.INSTANCE.toCommentUpdateRes(
            commentReadService.getCommentEntity(commentId));
    }
}
