package com.learn.user.repository;

import com.learn.user.dto.UserRegistrationDto;
import com.learn.user.entity.User;
import com.learn.user.exception.DataProcessingException;

import java.util.Optional;

public interface UserRepository {
    User save(UserRegistrationDto user) throws DataProcessingException;

    Optional<User> getUserById(Long userId);
}
