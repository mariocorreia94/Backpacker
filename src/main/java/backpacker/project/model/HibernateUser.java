package backpacker.project.model;


import backpacker.project.persistence.HibernateSessionManager;
import backpacker.project.utils.Security;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class HibernateUser {

    HibernateSessionManager sessionManager;

    public void newUser(User user) {

        Session session = sessionManager.beginTransaction();
        session.save(user);
    }

    public void removeUser(String username) {

        Session session = sessionManager.beginTransaction();

        Query query = session.createQuery("DELETE User WHERE username = :username");

        query.setString("username", username);

        query.executeUpdate();

    }

    public User findByName(String username) {

        Session session = sessionManager.beginTransaction();

        Query query = session.createQuery("FROM User WHERE username = :username");

        query.setString("username", username);

        return (User) query.uniqueResult();

    }

    public boolean authenticate(String username, String password) {

        User user = findByName(username);

        if (user == null || !user.getPassword().equals(password)) {
            return false;
        }

        return true;
    }

    public void setSessionManager(HibernateSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}