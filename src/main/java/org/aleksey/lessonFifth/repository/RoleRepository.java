package org.aleksey.lessonFifth.repository;

import org.aleksey.lessonFifth.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    Role create(Role role);

    Optional<Role> findById(Long id);

    List<Role> findAll();
}
