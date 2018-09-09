package backpacker.project.service;

import backpacker.project.model.User;

public interface UserService {

    User authenticate(String username, String password);

    void newUser(User user);

    void removeUser(String username);

    User findByName(String username);
}