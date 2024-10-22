package org.aleksey.lessonFourth.user.validation;

import org.aleksey.lessonFourth.user.dto.UserRegistrationDto;
import org.aleksey.lessonFourth.user.exception.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    private static final String CHECK_EMAIL_TYPE = "^(.+)@(.+)$";

    private static final String CHECK_PHONE_NUMBER = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

    public void isValid(UserRegistrationDto userRegistrationDto) {
        if (!isCorrectEmail(userRegistrationDto.email())) {
            throw new ValidationException("Email is not correct");
        }

        if (!isCorrectPhone(userRegistrationDto.phoneNumber())) {
            throw new ValidationException("Phone number is not correct");
        }

        if (!userRegistrationDto.password().equals(userRegistrationDto.repeatPassword())) {
            throw new ValidationException("Password does not match");
        }
    }

    private boolean isCorrectEmail(String email) {
        Pattern pattern = Pattern.compile(CHECK_EMAIL_TYPE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isCorrectPhone(String phone) {
        Pattern pattern = Pattern.compile(CHECK_PHONE_NUMBER);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
