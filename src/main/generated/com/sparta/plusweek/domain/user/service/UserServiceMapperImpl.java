package com.sparta.plusweek.domain.user.service;

import com.sparta.plusweek.domain.user.dto.UserLoginRes;
import com.sparta.plusweek.domain.user.dto.UserSignupRes;
import com.sparta.plusweek.domain.user.entity.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-21T19:11:33+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class UserServiceMapperImpl implements UserServiceMapper {

    @Override
    public UserSignupRes toUserSignupRes(User user) {
        if ( user == null ) {
            return null;
        }

        UserSignupRes.UserSignupResBuilder userSignupRes = UserSignupRes.builder();

        userSignupRes.userId( user.getUserId() );
        userSignupRes.username( user.getUsername() );
        userSignupRes.email( user.getEmail() );
        userSignupRes.role( user.getRole() );

        return userSignupRes.build();
    }

    @Override
    public UserLoginRes toUserLoginRes(User user) {
        if ( user == null ) {
            return null;
        }

        UserLoginRes.UserLoginResBuilder userLoginRes = UserLoginRes.builder();

        userLoginRes.userId( user.getUserId() );
        userLoginRes.username( user.getUsername() );
        userLoginRes.email( user.getEmail() );
        userLoginRes.role( user.getRole() );

        return userLoginRes.build();
    }
}
