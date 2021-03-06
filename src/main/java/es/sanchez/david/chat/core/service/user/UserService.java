package es.sanchez.david.chat.core.service.user;

import es.sanchez.david.chat.core.model.User;

import java.util.List;

public interface UserService {
    User findUser(String username);

    boolean isValidUser(String username, String password);

    User addUser(User user);

    List<User> getAll();
}
