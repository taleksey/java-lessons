package com.learn.liquibase.database.repositore;

import com.learn.liquibase.database.entity.User;

import java.util.Optional;
import java.util.List;

public interface UserRepository {
    User create(User user);

    Optional<User> findById(Long id);

    List<User> findAll();
}
