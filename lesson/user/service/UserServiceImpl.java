package lesson.user.service;

import lesson.user.dto.UserRegistrationDto;
import lesson.user.dto.UserResponseDto;
import lesson.user.entity.User;
import lesson.user.repository.UserRepositoryImpl;
import lesson.user.validation.UserValidator;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepositoryImpl userRepository;
    private final UserValidator userValidator;

    public UserServiceImpl(UserRepositoryImpl userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public UserResponseDto registerUser(UserRegistrationDto userRegistrationDto) {
        this.userValidator.isValid(userRegistrationDto);
        Long id = (Long) this.userRepository.save(userRegistrationDto);

        return new UserResponseDto(id, "name", "aa", "qqq");
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        Optional<User> user = this.userRepository.getUserById(userId);
        if (user.isEmpty()) {
            return new UserResponseDto(0L, "", "", "");
        }
        User currentUser = user.get();

        return new UserResponseDto(currentUser.getId(), currentUser.getName(), currentUser.getEmail(), currentUser.getPhoneNumber());
    }
}
