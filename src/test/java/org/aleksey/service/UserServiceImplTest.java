package org.aleksey.service;


import org.aleksey.lessonFourth.user.dto.UserRegistrationDto;
import org.aleksey.lessonFourth.user.dto.UserResponseDto;
import org.aleksey.lessonFourth.user.entity.User;
import org.aleksey.lessonFourth.user.exception.DataProcessingException;
import org.aleksey.lessonFourth.user.repository.UserRepositoryImpl;
import org.aleksey.lessonFourth.user.service.UserServiceImpl;
import org.aleksey.lessonFourth.user.validation.UserValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepositoryImpl userRepository;

    @Mock
    private UserValidator userValidator;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void registerUser() {
        Long id = 1L;
        String name = "test";
        String lastName = "test";
        String email = "test@test.com";
        String password = "test";
        String phoneNumber = "123456789";

        UserRegistrationDto user = new UserRegistrationDto(name, lastName, email, phoneNumber, password, password);
        when(userRepository.save(user)).thenReturn(new User(id, name, lastName, email, phoneNumber, password));
        doNothing().when(userValidator).isValid(user);

        User resultUser = userService.registerUser(user);
        assertEquals(resultUser.getName(), user.name());
        assertEquals(resultUser.getPhoneNumber(), user.phoneNumber());
        assertEquals(resultUser.getEmail(), user.email());

        verify(userValidator).isValid(user);
        verify(userRepository).save(user);
    }

    @Test
    void registerFailDBUser() {
        Long id = 1L;
        String name = "test";
        String lastName = "test";
        String email = "test@test.com";
        String password = "test";
        String phoneNumber = "123456789";
        SQLException sqlException = new SQLException("Database connection error");
        DataProcessingException dataProcessingException = new DataProcessingException("Can't create instance of user", sqlException);
        UserRegistrationDto user = new UserRegistrationDto(name, lastName, email, phoneNumber, password, password);
        doThrow(dataProcessingException).when(userRepository).save(user);
        doNothing().when(userValidator).isValid(user);

        DataProcessingException exception = assertThrows(DataProcessingException.class, () -> userService.registerUser(user));
        assertEquals("Can't create instance of user", exception.getMessage());

        verify(userValidator).isValid(user);
        verify(userRepository).save(user);
        verify(userRepository, never()).getUserById(id);
    }

    @Test
    void getUserById() {
        Long id = 1L;
        String name = "test";
        String lastName = "test";
        String email = "test@test.com";
        String password = "test";
        String phoneNumber = "123456789";
        when(userRepository.getUserById(id)).thenReturn(Optional.of(new User(id, name, lastName, email, phoneNumber, password)));
        UserResponseDto userResponseDto = userService.getUserById(id);

        assertEquals(userResponseDto.name(), name);
        assertEquals(userResponseDto.email(), email);
        assertEquals(userResponseDto.phone(), phoneNumber);
        verify(userRepository).getUserById(id);
    }
}
