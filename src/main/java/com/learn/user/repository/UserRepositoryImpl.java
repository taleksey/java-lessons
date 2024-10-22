package com.learn.user.repository;

import com.learn.user.dto.UserRegistrationDto;
import com.learn.user.entity.User;
import com.learn.user.exception.DataProcessingException;
import com.learn.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {
    @SuppressWarnings("checkstyle:MagicNumber")
    public User save(UserRegistrationDto user) throws DataProcessingException {
        String sqlRequest = "INSERT INTO user (name, last_name, email, phone, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest,
                     Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.name());
            preparedStatement.setString(2, user.lastName());
            preparedStatement.setString(3, user.email());
            preparedStatement.setString(4, user.phoneNumber());
            preparedStatement.setString(5, user.password());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);

                return new User(id, user.name(), user.lastName(), user.email(), user.phoneNumber(), user.password());
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create instance of user:"
                    + user.toString()
                    + " and add it to DB " + e.getMessage(), e);
        }
        return new User(0L, "", "", "", "", "");
    }

    public Optional<User> getUserById(Long userId) {
        String sqlRequest = "SELECT * FROM user WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(parseUser(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't find car by id. ID=" + userId, e);
        }
        return Optional.empty();

    }

    private User parseUser(ResultSet requestResult) {
        try {
            Long id = requestResult.getObject("id", Long.class);
            String name = requestResult.getString("name");
            String lastName = requestResult.getString("last_name");
            String email = requestResult.getString("email");
            String phoneNumber = requestResult.getString("phone");
            String password = requestResult.getString("password");
            return new User(id, name, lastName, email, phoneNumber, password);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't parse car "
                    + "data from resultSet", e);
        }
    }

}
