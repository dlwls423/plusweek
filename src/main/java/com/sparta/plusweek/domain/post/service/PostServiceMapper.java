package com.sparta.plusweek.domain.post.service;

import com.sparta.plusweek.domain.post.dto.PostGetAllPostsRes;
import com.sparta.plusweek.domain.post.dto.PostGetAllPostsResList;
import com.sparta.plusweek.domain.post.entity.Post;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostServiceMapper {
    PostServiceMapper INSTANCE = Mappers.getMapper(PostServiceMapper.class);

    List<PostGetAllPostsRes> toPostGetAllPostsListRes(List<Post> postList);
}
