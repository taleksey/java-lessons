package com.learn.user.service;

import com.learn.user.dto.UserRegistrationDto;
import com.learn.user.dto.UserResponseDto;
import com.learn.user.entity.User;

interface UserService {
    User registerUser(UserRegistrationDto userRegistrationDto);

    UserResponseDto getUserById(Long userId);
}
