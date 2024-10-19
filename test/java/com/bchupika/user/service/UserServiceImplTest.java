package com.bchupika.user.service;

import com.bchupika.user.dto.UserRegistrationDto;
import com.bchupika.user.dto.UserResponseDto;
import com.bchupika.user.entity.User;
import com.bchupika.user.exception.DataProcessingException;
import com.bchupika.user.repository.UserRepositoryImpl;
import com.bchupika.user.validation.UserValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
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
        when(userRepository.save(user)).thenReturn(id);
        when(userRepository.getUserById(id)).thenReturn(Optional.of(new User(id, name, lastName, email, phoneNumber, password)));
        doNothing().when(userValidator).isValid(user);

        UserResponseDto userResponseDto = userService.registerUser(user);
        assertEquals(userResponseDto.name(), user.getName());
        assertEquals(userResponseDto.email(), user.getEmail());
        assertEquals(userResponseDto.phone(), user.getPhoneNumber());

        verify(userValidator).isValid(user);
        verify(userRepository).save(user);
        verify(userRepository).getUserById(id);
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