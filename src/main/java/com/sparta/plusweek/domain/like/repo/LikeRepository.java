package com.sparta.plusweek.domain.like.repo;

import com.sparta.plusweek.domain.like.entity.Like;
import com.sparta.plusweek.domain.post.entity.Post;
import com.sparta.plusweek.domain.user.entity.User;
import java.util.List;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Like.class, idClass = Long.class)
public interface LikeRepository {

    List<Like> findAllByPost(Post post);

    Like findByPostAndUser(Post post, User user);

    void save(Like like);

    void delete(Like like);
}
