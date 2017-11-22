package backpacker.project.service;

import backpacker.project.model.HibernateUser;
import backpacker.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private HibernateUser hibernateUser;

    @Transactional
    @Override
    public boolean authenticate(String username, String password) {

        return hibernateUser.authenticate(username, password);

    }

    @Transactional
    @Override
    public void newUser(User user) {

        hibernateUser.newUser(user);

    }

    @Transactional
    @Override
    public void removeUser(String username) {

        hibernateUser.removeUser(username);

    }

    @Transactional
    @Override
    public User findByName(String username) {

        return hibernateUser.findByName(username);

    }

    public void setHibernateUser(HibernateUser hibernateUser) {
        this.hibernateUser = hibernateUser;
    }
}
