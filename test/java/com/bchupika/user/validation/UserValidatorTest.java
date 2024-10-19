package com.bchupika.user.validation;

import com.bchupika.user.dto.UserRegistrationDto;
import com.bchupika.user.exception.DataProcessingException;
import com.bchupika.user.exception.EmailException;
import com.bchupika.user.exception.PasswordNotEqual;
import com.bchupika.user.exception.PhoneNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserValidatorTest {
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

        EmailException exception = assertThrows(EmailException.class, () -> userValidator.isValid(userDto));

        assertEquals("Email is not correct", exception.getMessage());
    }

    @Test
    void wrongPhone() {
        UserRegistrationDto userDto = new UserRegistrationDto(userName, lastName, email, "dsadasda", password, repeatPassword);

        PhoneNumberException exception = assertThrows(PhoneNumberException.class, () -> userValidator.isValid(userDto));

        assertEquals("Phone number is not correct", exception.getMessage());
    }

    @Test
    void passwordAreNotTheSame() {
        UserRegistrationDto userDto = new UserRegistrationDto(userName, lastName, email, phoneNumber, password, "repeatPassword");

        PasswordNotEqual exception = assertThrows(PasswordNotEqual.class, () -> userValidator.isValid(userDto));

        assertEquals("Password does not match", exception.getMessage());
    }

    @Test
    void isCorrect() {
        UserRegistrationDto userDto = new UserRegistrationDto(userName, lastName, email, phoneNumber, password, repeatPassword);


        assertDoesNotThrow(() -> userValidator.isValid(userDto));
    }
}