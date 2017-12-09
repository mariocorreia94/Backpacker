package backpacker.project.service;

import backpacker.project.model.User;

import java.util.List;

public interface UserService {

    User authenticate(String username, String password);

    void newUser(User user);

    void removeUser(String username);

    User findByName(String username);
}