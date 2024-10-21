package com.learn.user.dto;

public record UserRegistrationDto(String name, String lastName, String email, String phoneNumber, String password,
                                  String repeatPassword) {

}
