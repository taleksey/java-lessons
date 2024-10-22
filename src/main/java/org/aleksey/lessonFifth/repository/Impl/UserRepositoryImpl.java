package org.aleksey.lessonFifth.repository.Impl;

import org.aleksey.lessonFifth.entity.User;
import org.aleksey.lessonFifth.repository.UserRepository;
import org.aleksey.lessonFifth.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

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
