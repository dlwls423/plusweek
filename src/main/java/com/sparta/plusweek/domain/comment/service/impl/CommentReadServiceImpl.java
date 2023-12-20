package com.sparta.plusweek.domain.comment.service.impl;

import com.sparta.plusweek.domain.comment.dto.CommentGetRes;
import com.sparta.plusweek.domain.comment.entity.Comment;
import com.sparta.plusweek.domain.comment.repo.CommentRepository;
import com.sparta.plusweek.domain.comment.service.CommentReadService;
import com.sparta.plusweek.domain.comment.service.CommentServiceMapper;
import com.sparta.plusweek.domain.comment.validator.CommentValidator;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.post.service.PostReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentReadServiceImpl implements CommentReadService {

    private final CommentRepository commentRepository;

    private final PostReadService postReadService;

    @Override
    public Comment getCommentEntity(Long commentId) {
        Comment comment = commentRepository.findByCommentId(commentId);
        CommentValidator.validate(comment);
        return comment;
    }

    @Override
    public Page<CommentGetRes> getAllComments(Long postId, int page, int size, String sortBy,
        boolean isAsc) {
        Post post = postReadService.getPostEntity(postId);

        // 페이징 처리
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Comment> commentList = commentRepository.findAllByPost(post, pageable);
        return commentList.map(CommentServiceMapper.INSTANCE::toCommentGetRes);
    }
}
