package com.learn.liquibase.database.repositore.Impl;

import com.learn.liquibase.database.entity.User;
import com.learn.liquibase.database.repositore.UserRepository;
import com.learn.liquibase.database.util.HibernateUtil;
import org.hibernate.SessionFactory;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public User create(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        }
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(sessionFactory.openSession().find(User.class, id));
    }

    @Override
    public List<User> findAll() {
        return sessionFactory.openSession()
            .createQuery("select u from User u", User.class)
            .getResultList();
    }
}
