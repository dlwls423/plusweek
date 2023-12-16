package com.sparta.plusweek.domain.post.repo;

import com.sparta.plusweek.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
