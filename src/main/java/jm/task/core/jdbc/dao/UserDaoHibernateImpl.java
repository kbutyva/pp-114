package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }

    Util util = new Util();

    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        SessionFactory sessionFactory = util.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        try {
            Transaction transaction = currentSession.beginTransaction();
            currentSession.save(user);
            transaction.commit();
        } finally {
            sessionFactory.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        SessionFactory sessionFactory = util.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        try {
            currentSession.beginTransaction();
            User user = currentSession.get(User.class, id);
            currentSession.delete(user);
            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        SessionFactory sessionFactory = util.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        List<User> list;
        try {
            Transaction transaction = currentSession.beginTransaction();

            list = currentSession.createQuery("from User", User.class).list();

            transaction.commit();
        } finally {
            sessionFactory.close();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {

    }
}
