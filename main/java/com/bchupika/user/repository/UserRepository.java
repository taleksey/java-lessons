package com.bchupika.user.repository;

import com.bchupika.user.dto.UserRegistrationDto;
import com.bchupika.user.entity.User;
import com.bchupika.user.exception.DataProcessingException;

import java.util.Optional;

public interface UserRepository {
    Number save(UserRegistrationDto user) throws DataProcessingException;

    Optional<User> getUserById(Long userId);
}
