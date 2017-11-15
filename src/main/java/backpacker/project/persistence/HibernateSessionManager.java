package backpacker.project.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public class HibernateSessionManager {

    private SessionFactory sessionFactory;

    public HibernateSessionManager() {
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        // Hibernate will automatically open a new session if needed
        // Closing the session is not required
        return sessionFactory.getCurrentSession();
    }

    public Session beginTransaction() {

        Session session = getSession();
        session.beginTransaction();
        return session;
    }
}
