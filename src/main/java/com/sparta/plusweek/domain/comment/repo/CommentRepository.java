package com.sparta.plusweek.domain.comment.repo;

import com.sparta.plusweek.domain.comment.entity.Comment;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository {

    Comment save(Comment comment);
}
