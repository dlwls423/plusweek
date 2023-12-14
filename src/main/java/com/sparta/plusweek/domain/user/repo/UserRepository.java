package com.sparta.plusweek.domain.user.repo;

import com.sparta.plusweek.domain.user.entity.User;
import com.sparta.plusweek.domain.user.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
