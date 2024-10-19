package lesson.user.repository;

import lesson.user.dto.UserRegistrationDto;
import lesson.user.entity.User;

import java.util.Optional;

public interface UserRepository {
    Number save(UserRegistrationDto user);

    Optional<User> getUserById(Long userId);
}
