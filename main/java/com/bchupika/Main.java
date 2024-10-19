package com.bchupika;

import com.bchupika.user.dto.UserRegistrationDto;
import com.bchupika.user.dto.UserResponseDto;
import com.bchupika.user.repository.UserRepositoryImpl;
import com.bchupika.user.service.UserServiceImpl;
import com.bchupika.user.validation.UserValidator;

public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        UserValidator userValidator = new UserValidator();
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto("alex", "test",
                "test@email.com", "0981234343", "q1w2e3", "q1w2e3");

        UserServiceImpl userService = new UserServiceImpl(userRepository, userValidator);
        UserResponseDto userRegisterUser = userService.registerUser(userRegistrationDto);
        System.out.println(userRegisterUser);
    }
}
