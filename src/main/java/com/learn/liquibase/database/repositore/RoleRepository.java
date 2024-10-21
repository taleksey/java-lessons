package com.learn.liquibase.database.repositore;

import com.learn.liquibase.database.entity.Role;

import java.util.Optional;
import java.util.List;

public interface RoleRepository {
    Role create(Role role);

    Optional<Role> findById(Long id);

    List<Role> findAll();
}
