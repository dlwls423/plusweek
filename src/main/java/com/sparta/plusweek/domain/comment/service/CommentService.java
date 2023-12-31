package com.sparta.plusweek.domain.comment.service;

import com.sparta.plusweek.domain.comment.dto.CommentCreateReq;
import com.sparta.plusweek.domain.comment.dto.CommentCreateRes;
import com.sparta.plusweek.domain.comment.dto.CommentUpdateReq;
import com.sparta.plusweek.domain.comment.dto.CommentUpdateRes;
import com.sparta.plusweek.domain.user.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    CommentCreateRes createComment(CommentCreateReq req, User user);

    CommentUpdateRes updateComment(Long commentId, CommentUpdateReq req, User user);

    void deleteComment(Long commentId, User user);

}
