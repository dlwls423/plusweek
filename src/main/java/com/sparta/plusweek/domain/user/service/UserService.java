package com.sparta.plusweek.domain.user.service;

import com.sparta.plusweek.domain.user.dto.UserConfirmUsernameReq;
import com.sparta.plusweek.domain.user.dto.UserConfirmUsernameRes;
import com.sparta.plusweek.domain.user.dto.UserEmailReq;
import com.sparta.plusweek.domain.user.dto.UserLoginReq;
import com.sparta.plusweek.domain.user.dto.UserLoginRes;
import com.sparta.plusweek.domain.user.dto.UserSignupReq;
import com.sparta.plusweek.domain.user.dto.UserSignupRes;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserConfirmUsernameRes confirmUsername(UserConfirmUsernameReq req);

    UserSignupRes signup(UserSignupReq req);

    UserLoginRes login(UserLoginReq req);

    void sendMail(UserEmailReq req);
}
