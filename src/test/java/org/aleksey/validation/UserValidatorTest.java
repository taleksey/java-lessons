package org.aleksey.validation;

import org.aleksey.lessonFourth.user.dto.UserRegistrationDto;
import org.aleksey.lessonFourth.user.exception.ValidationException;
import org.aleksey.lessonFourth.user.validation.UserValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserValidatorTest {
    private UserValidator userValidator;
    private String userName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String repeatPassword;

    @BeforeEach
    void setUp() {
        userValidator = new UserValidator();
        userName = "UserName";
        lastName = "LastName";
        email = "email@email.com";
        phoneNumber = "(123)4567890";
        password = "password";
        repeatPassword = "password";
    }

    @Test
    void wrongEmail() {
        UserRegistrationDto userDto = new UserRegistrationDto(userName, lastName, "email", phoneNumber, password, repeatPassword);

        ValidationException exception = assertThrows(ValidationException.class, () -> userValidator.isValid(userDto));

        assertEquals("Email is not correct", exception.getMessage());
    }

    @Test
    void wrongPhone() {
        UserRegistrationDto userDto = new UserRegistrationDto(userName, lastName, email, "dsadasda", password, repeatPassword);

        ValidationException exception = assertThrows(ValidationException.class, () -> userValidator.isValid(userDto));

        assertEquals("Phone number is not correct", exception.getMessage());
    }

    @Test
    void passwordAreNotTheSame() {
        UserRegistrationDto userDto = new UserRegistrationDto(userName, lastName, email, phoneNumber, password, "repeatPassword");

        ValidationException exception = assertThrows(ValidationException.class, () -> userValidator.isValid(userDto));

        assertEquals("Password does not match", exception.getMessage());
    }

    @Test
    void isCorrect() {
        UserRegistrationDto userDto = new UserRegistrationDto(userName, lastName, email, phoneNumber, password, repeatPassword);


        assertDoesNotThrow(() -> userValidator.isValid(userDto));
    }
}
