package com.learn.liquibase.database.repositore.Impl;

import com.learn.liquibase.database.entity.Role;
import com.learn.liquibase.database.repositore.RoleRepository;
import com.learn.liquibase.database.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class RoleRepositoryImpl implements RoleRepository {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Role create(Role role) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(role);
            transaction.commit();
        }
        return role;

    }

    @Override
    public Optional<Role> findById(Long id) {
        return Optional.ofNullable(sessionFactory.openSession().find(Role.class, id));
    }

    @Override
    public List<Role> findAll() {
        return sessionFactory.openSession()
            .createQuery("select r from Role r", Role.class)
            .getResultList();

    }
}
