package com.sparta.plusweek.domain.like.repo;

import com.sparta.plusweek.domain.like.entity.Like;
import com.sparta.plusweek.domain.post.entity.Post;
import java.util.List;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Like.class, idClass = Long.class)
public interface LikeRepository {

    List<Like> findAllByPost(Post post);
}
