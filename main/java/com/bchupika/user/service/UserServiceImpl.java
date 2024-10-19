package com.bchupika.user.service;

import com.bchupika.user.dto.UserRegistrationDto;
import com.bchupika.user.dto.UserResponseDto;
import com.bchupika.user.entity.User;
import com.bchupika.user.repository.UserRepositoryImpl;
import com.bchupika.user.validation.UserValidator;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepositoryImpl userRepository;
    private final UserValidator userValidator;

    public UserServiceImpl(UserRepositoryImpl userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public UserResponseDto registerUser(UserRegistrationDto userRegistrationDto) {
        this.userValidator.isValid(userRegistrationDto);
        Long id = (Long) this.userRepository.save(userRegistrationDto);

        return this.getUserById(id);
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
