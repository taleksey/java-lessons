package com.bchupika.user.service;

import com.bchupika.user.dto.UserRegistrationDto;
import com.bchupika.user.dto.UserResponseDto;

interface UserService {
    UserResponseDto registerUser(UserRegistrationDto userRegistrationDto);

    UserResponseDto getUserById(Long userId);
}
