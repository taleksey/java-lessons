package com.learn;

import com.learn.user.dto.UserRegistrationDto;
import com.learn.user.entity.User;
import com.learn.user.repository.UserRepositoryImpl;
import com.learn.user.service.UserServiceImpl;
import com.learn.user.validation.UserValidator;

public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        UserValidator userValidator = new UserValidator();
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto("alex", "test",
                "test@email.com", "0981234343", "q1w2e3", "q1w2e3");

        UserServiceImpl userService = new UserServiceImpl(userRepository, userValidator);
        User userRegisterUser = userService.registerUser(userRegistrationDto);
        System.out.println(userRegisterUser);
    }
}
