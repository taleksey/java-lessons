package org.aleksey.lessonFourth.user.service;

import org.aleksey.lessonFourth.user.dto.UserRegistrationDto;
import org.aleksey.lessonFourth.user.dto.UserResponseDto;
import org.aleksey.lessonFourth.user.entity.User;

interface UserService {
    User registerUser(UserRegistrationDto userRegistrationDto);

    UserResponseDto getUserById(Long userId);
}
