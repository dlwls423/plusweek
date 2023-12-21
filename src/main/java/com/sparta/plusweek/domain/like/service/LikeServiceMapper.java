package com.sparta.plusweek.domain.like.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LikeServiceMapper {

    LikeServiceMapper INSTANCE = Mappers.getMapper(LikeServiceMapper.class);
    
}
