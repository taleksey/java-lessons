package org.aleksey.lessonFourth.user.entity;

public class User {
    private final Long id;
    private final String name;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String password;

    public User(Long id, String name, String lastName, String email, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
