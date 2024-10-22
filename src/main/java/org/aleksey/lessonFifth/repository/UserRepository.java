package org.aleksey.lessonFifth.repository;

import org.aleksey.lessonFifth.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User create(User user);

    Optional<User> findById(Long id);

    List<User> findAll();
}
