package com.sparta.plusweek.security;

import com.sparta.plusweek.domain.user.entity.User;
import com.sparta.plusweek.domain.user.repo.UserRepository;
import com.sparta.plusweek.domain.user.validator.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        UserValidator.validate(user);
        return new UserDetailsImpl(user);
    }
}
