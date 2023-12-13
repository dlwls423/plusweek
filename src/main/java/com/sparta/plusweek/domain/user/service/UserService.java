package com.sparta.plusweek.domain.user.service;

import com.sparta.plusweek.domain.user.dto.SignupRequestDto;
import com.sparta.plusweek.domain.user.dto.SignupResponseDto;
import com.sparta.plusweek.domain.user.entity.Role;
import com.sparta.plusweek.domain.user.entity.User;
import com.sparta.plusweek.domain.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignupResponseDto signup(SignupRequestDto requestDto) {
        String password = requestDto.getPassword();
        String confirmPassword = requestDto.getConfirmPassword();
        if(!password.equals(confirmPassword)){
            throw new IllegalArgumentException("재확인 비밀번호와 일치하지 않습니다.");
        }

        if(userRepository.findByUsername(requestDto.getUsername()).isPresent()){
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }

        User saveUser = userRepository.save(User.builder()
            .username(requestDto.getUsername())
            .password(requestDto.getPassword())
            .email(requestDto.getEmail())
            .role(Role.ROLE_USER)
            .build());

         return UserServiceMapper.INSTANCE.toSignupResponseDto(saveUser);
    }

}
