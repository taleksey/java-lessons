package org.aleksey.lessonFourth.user.repository;

import org.aleksey.lessonFourth.user.dto.UserRegistrationDto;
import org.aleksey.lessonFourth.user.entity.User;
import org.aleksey.lessonFourth.user.exception.DataProcessingException;

import java.util.Optional;

public interface UserRepository {
    User save(UserRegistrationDto user) throws DataProcessingException;

    Optional<User> getUserById(Long userId);
}

