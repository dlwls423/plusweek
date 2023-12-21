package com.sparta.plusweek.domain.user.service.impl;

import com.sparta.plusweek.domain.user.dto.UserConfirmUsernameReq;
import com.sparta.plusweek.domain.user.dto.UserConfirmUsernameRes;
import com.sparta.plusweek.domain.user.dto.UserEmailCodeReq;
import com.sparta.plusweek.domain.user.dto.UserEmailReq;
import com.sparta.plusweek.domain.user.dto.UserLoginReq;
import com.sparta.plusweek.domain.user.dto.UserLoginRes;
import com.sparta.plusweek.domain.user.dto.UserSignupReq;
import com.sparta.plusweek.domain.user.dto.UserSignupRes;
import com.sparta.plusweek.domain.user.entity.Role;
import com.sparta.plusweek.domain.user.entity.User;
import com.sparta.plusweek.domain.user.repo.UserRepository;
import com.sparta.plusweek.domain.user.service.UserService;
import com.sparta.plusweek.domain.user.service.UserServiceMapper;
import com.sparta.plusweek.domain.user.validator.UserValidator;
import com.sparta.plusweek.global.mail.AuthEmail;
import com.sparta.plusweek.global.mail.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailUtil emailUtil;

    @Override
    public UserConfirmUsernameRes confirmUsername(UserConfirmUsernameReq req) {
        boolean duplicated = userRepository.findByUsername(req.getUsername()) != null;
        return UserConfirmUsernameRes.builder().duplicated(duplicated).build();
    }

    @Override
    public void sendMail(UserEmailReq req) {
        emailUtil.sendMessage(req.getEmail(), "이메일 인증");
    }

    @Override
    public void verifyCode(UserEmailCodeReq req) {
        emailUtil.checkCode(req.getEmail(), req.getCode());
    }

    @Override
    public UserSignupRes signup(UserSignupReq req) {
        UserValidator.validate(req);
        User user = userRepository.findByUsername(req.getUsername());
        UserValidator.checkIsDuplicatedName(user);
        checkAuthorizedEmail(req.getEmail());

        User saveUser = userRepository.save(User.builder()
            .username(req.getUsername())
            .password(passwordEncoder.encode(req.getPassword()))
            .email(req.getEmail())
            .role(Role.ROLE_USER)
            .build());

        return UserServiceMapper.INSTANCE.toUserSignupRes(saveUser);
    }

    @Override
    public UserLoginRes login(UserLoginReq req) {
        User user = userRepository.findByUsername(req.getUsername());
        UserValidator.validate(user);

        String password = req.getPassword();
        UserValidator.verifyPassword(passwordEncoder, password, user.getPassword());

        return UserServiceMapper.INSTANCE.toUserLoginRes(user);
    }

    private void checkAuthorizedEmail(String email) {
        AuthEmail authEmail = emailUtil.getAuthEmail(email);
        if (!authEmail.isChecked()) {
            throw new IllegalArgumentException(("이메일 인증을 완료해주세요."));
        }
    }
}
