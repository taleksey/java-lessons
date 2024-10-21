package com.learn.user.service;

import com.learn.user.dto.UserRegistrationDto;
import com.learn.user.dto.UserResponseDto;
import com.learn.user.entity.User;
import com.learn.user.repository.UserRepositoryImpl;
import com.learn.user.validation.UserValidator;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepositoryImpl userRepository;
    private final UserValidator userValidator;

    public UserServiceImpl(UserRepositoryImpl userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public User registerUser(UserRegistrationDto userRegistrationDto) {
        this.userValidator.isValid(userRegistrationDto);
        return this.userRepository.save(userRegistrationDto);
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        Optional<User> user = this.userRepository.getUserById(userId);
        if (user.isEmpty()) {
            return new UserResponseDto(0L, "", "", "");
        }
        User currentUser = user.get();

        return new UserResponseDto(currentUser.getId(), currentUser.getName(), currentUser.getEmail(), currentUser.getPhoneNumber());
    }
}
