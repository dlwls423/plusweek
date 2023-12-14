package com.sparta.plusweek.domain.post.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostGetAllPostsResList {
    List<PostGetAllPostsRes> postList;

    @Builder
    public PostGetAllPostsResList(List<PostGetAllPostsRes> resList) {
        this.postList = resList;
    }
}
