package com.sparta.plusweek.domain.comment.service;

import com.sparta.plusweek.domain.comment.dto.CommentCreateRes;
import com.sparta.plusweek.domain.comment.dto.CommentGetRes;
import com.sparta.plusweek.domain.comment.dto.CommentUpdateRes;
import com.sparta.plusweek.domain.comment.entity.Comment;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-22T10:58:58+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class CommentServiceMapperImpl implements CommentServiceMapper {

    @Override
    public CommentCreateRes toCommentCreateRes(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentCreateRes.CommentCreateResBuilder commentCreateRes = CommentCreateRes.builder();

        commentCreateRes.comment( comment );

        return commentCreateRes.build();
    }

    @Override
    public CommentUpdateRes toCommentUpdateRes(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentUpdateRes.CommentUpdateResBuilder commentUpdateRes = CommentUpdateRes.builder();

        commentUpdateRes.comment( comment );

        return commentUpdateRes.build();
    }

    @Override
    public CommentGetRes toCommentGetRes(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentGetRes.CommentGetResBuilder commentGetRes = CommentGetRes.builder();

        commentGetRes.comment( comment );

        return commentGetRes.build();
    }
}
