package com.example.personalproject.dao.hibernate;

import com.example.personalproject.dao.UserDao;
import com.example.personalproject.domain.User;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
@Repository
public class UserDaoHibernate implements UserDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public User getUserByID(int userID) {
        Session session = factory.getCurrentSession();
        return session.get(User.class, userID);
    }
    @Override
    public List<User> getAllUser() {
        Session session = factory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
        TypedQuery<User> query = session.createQuery(
                "SELECT u FROM User u",
                User.class);
        List<User> users = query.getResultList();
//        transaction.commit();
        return users;
    }

    @Override
    public Optional<User> validateLogin(User target) {
        User user = null;

        Session session = factory.getCurrentSession();
        TypedQuery<User> query = session.createQuery(
                "SELECT u FROM User u WHERE u.userName = :p1 AND u.password = :p2 AND u.isActive = true",
                User.class);

        query.setParameter("p1", target.getUserName());
        query.setParameter("p2", target.getPassword());

        try{
            user = query.getSingleResult();
        } catch (NoResultException noResultException) {
            System.out.println("UserDaoHibernate: " + noResultException);
            return Optional.empty();
        } catch (NonUniqueResultException nonUniqueResultException) {
            System.out.println("UserDaoHibernate: " + target.getUserID() + "is DUPLICATED!!!");
            return Optional.of(target);
        }

        return Optional.of(user);
    }
    @Override
    public void createNewUser(User user) {
        Session session = factory.getCurrentSession();
        session.save(user);
    }
    @Override
    public void updateUser(User user) {
        Session session = factory.getCurrentSession();
        session.update(user);
    }
    @Override
    public void deleteUser(int userID) {
        User target = new User();
        target.setUserID(userID);
        Session session = factory.getCurrentSession();
        session.delete(target);
    }
}
