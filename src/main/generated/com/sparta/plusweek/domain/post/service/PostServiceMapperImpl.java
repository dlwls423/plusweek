package com.sparta.plusweek.domain.post.service;

import com.sparta.plusweek.domain.post.dto.PostCreateRes;
import com.sparta.plusweek.domain.post.dto.PostGetAllRes;
import com.sparta.plusweek.domain.post.dto.PostGetRes;
import com.sparta.plusweek.domain.post.dto.PostUpdateRes;
import com.sparta.plusweek.domain.post.entity.Post;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-21T19:11:33+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class PostServiceMapperImpl implements PostServiceMapper {

    @Override
    public PostGetAllRes toPostGetAllRes(Post post) {
        if ( post == null ) {
            return null;
        }

        PostGetAllRes.PostGetAllResBuilder postGetAllRes = PostGetAllRes.builder();

        postGetAllRes.post( post );

        return postGetAllRes.build();
    }

    @Override
    public PostGetRes toPostGetRes(Post post) {
        if ( post == null ) {
            return null;
        }

        PostGetRes.PostGetResBuilder postGetRes = PostGetRes.builder();

        postGetRes.post( post );

        return postGetRes.build();
    }

    @Override
    public PostCreateRes toPostCreateRes(Post post) {
        if ( post == null ) {
            return null;
        }

        PostCreateRes.PostCreateResBuilder postCreateRes = PostCreateRes.builder();

        postCreateRes.post( post );

        return postCreateRes.build();
    }

    @Override
    public PostUpdateRes toPostUpdateRes(Post post) {
        if ( post == null ) {
            return null;
        }

        PostUpdateRes.PostUpdateResBuilder postUpdateRes = PostUpdateRes.builder();

        postUpdateRes.post( post );

        return postUpdateRes.build();
    }
}
