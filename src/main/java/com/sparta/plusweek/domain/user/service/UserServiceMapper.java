package com.sparta.plusweek.domain.user.service;

import com.sparta.plusweek.domain.user.dto.SignupResponseDto;
import com.sparta.plusweek.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserServiceMapper {
    UserServiceMapper INSTANCE = Mappers.getMapper(UserServiceMapper.class);

    SignupResponseDto toSignupResponseDto(User user);
}
