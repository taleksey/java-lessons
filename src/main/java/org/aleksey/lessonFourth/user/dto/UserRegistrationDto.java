package org.aleksey.lessonFourth.user.dto;

public record UserRegistrationDto(String name, String lastName, String email, String phoneNumber, String password,
                                  String repeatPassword) {
}
