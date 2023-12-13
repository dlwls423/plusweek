package com.sparta.plusweek.domain.user.repo;

import com.sparta.plusweek.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
