package com.sparta.plusweek.domain.post.repo;

import com.sparta.plusweek.domain.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Post.class, idClass = Long.class)
public interface PostRepository {

    Post save(Post post);

    Page<Post> findAll(Pageable pageable);

    Post findByPostId(Long postId);

}
