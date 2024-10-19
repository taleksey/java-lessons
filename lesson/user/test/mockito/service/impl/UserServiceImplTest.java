package lesson.user.test.mockito.service.impl;

import lesson.user.dto.UserRegistrationDto;
import lesson.user.exception.EmailException;
import lesson.user.repository.UserRepository;
import lesson.user.service.UserServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void registerUserWithIncorrectEmail() {
        Long id = 1L;
        UserRegistrationDto user = new UserRegistrationDto("name", "lastname", "aaaa", "123456789", "12", "12");
        when(userRepository.save(user)).thenReturn(id);
        when(userService.registerUser(user)).thenThrow(new EmailException("Email is not correct"));
    }
}

