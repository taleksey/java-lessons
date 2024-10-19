
import lesson.user.dto.UserRegistrationDto;
import lesson.user.dto.UserResponseDto;
import lesson.user.repository.UserRepositoryImpl;
import lesson.user.service.UserServiceImpl;
import lesson.user.validation.UserValidator;

public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        UserValidator userValidator = new UserValidator();
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto("alex", "test",
                "test@email.com", "0981234343", "q1w2e3", "q1w2e3");

        UserServiceImpl userService = new UserServiceImpl(userRepository, userValidator);
        UserResponseDto userRegisterUser = userService.registerUser(userRegistrationDto);
        System.out.println(userRegisterUser);
    }
}
