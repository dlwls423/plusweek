package com.sparta.plusweek.domain.user.repo;

import com.sparta.plusweek.domain.user.entity.User;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = User.class, idClass = Long.class)
public interface UserRepository extends UserRepositoryCustom {

    User findByUsername(String username);

    User save(User user);
}
