package backpacker.project.model;


import backpacker.project.persistence.HibernateSessionManager;
import backpacker.project.utils.Security;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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

        try{
            return (User) query.uniqueResult();
        } catch (HibernateException e) {
            return null;
        }

    }

    public User authenticate(String username, String password) {

        User user = findByName(username);

        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }

        return user;
    }

    public void setSessionManager(HibernateSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}