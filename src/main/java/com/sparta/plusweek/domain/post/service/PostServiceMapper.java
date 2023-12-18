package com.sparta.plusweek.domain.post.service;

import com.sparta.plusweek.domain.post.dto.PostCreatePostRes;
import com.sparta.plusweek.domain.post.dto.PostGetAllPostsRes;
import com.sparta.plusweek.domain.post.dto.PostGetPostRes;
import com.sparta.plusweek.domain.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostServiceMapper {

    PostServiceMapper INSTANCE = Mappers.getMapper(PostServiceMapper.class);

    PostGetAllPostsRes toPostGetAllPostsRes(Post post);

    PostGetPostRes toPostGetPostRes(Post post);

    PostCreatePostRes toPostCreatePostRes(Post post);
}
