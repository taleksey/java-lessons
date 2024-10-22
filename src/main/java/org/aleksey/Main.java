package org.aleksey;

import org.aleksey.lessonFourth.user.dto.UserRegistrationDto;
import org.aleksey.lessonFourth.user.entity.User;
import org.aleksey.lessonFourth.user.repository.UserRepositoryImpl;
import org.aleksey.lessonFourth.user.service.UserServiceImpl;
import org.aleksey.lessonFourth.user.validation.UserValidator;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
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
