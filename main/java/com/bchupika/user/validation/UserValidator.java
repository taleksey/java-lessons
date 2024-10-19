package com.bchupika.user.validation;

import com.bchupika.user.dto.UserRegistrationDto;
import com.bchupika.user.exception.EmailException;
import com.bchupika.user.exception.PasswordNotEqual;
import com.bchupika.user.exception.PhoneNumberException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public void isValid(UserRegistrationDto userRegistrationDto) {
        if (!isCorrectEmail(userRegistrationDto.getEmail())) {
            throw new EmailException("Email is not correct");
        }

        if (!isCorrectPhone(userRegistrationDto.getPhoneNumber())) {
            throw new PhoneNumberException("Phone number is not correct");
        }

        if (!userRegistrationDto.getPassword().equals(userRegistrationDto.getRepeatPassword())) {
            throw new PasswordNotEqual("Password does not match");
        }
    }

    private boolean isCorrectEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isCorrectPhone(String phone) {
        String regex = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
