package lesson.user.service;

import lesson.user.dto.UserRegistrationDto;
import lesson.user.dto.UserResponseDto;

interface UserService {
    UserResponseDto registerUser(UserRegistrationDto userRegistrationDto);

    UserResponseDto getUserById(Long userId);
}
