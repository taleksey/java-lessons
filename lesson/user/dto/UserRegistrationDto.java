package lesson.user.dto;

public class UserRegistrationDto {
    private final String name;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String password;
    private final String repeatPassword;

    public UserRegistrationDto(String name, String lastName, String email, String phoneNumber, String password, String repeatPassword) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

}
