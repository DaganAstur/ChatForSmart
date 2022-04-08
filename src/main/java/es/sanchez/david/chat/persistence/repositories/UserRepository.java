package es.sanchez.david.chat.persistence.repositories;

import es.sanchez.david.chat.core.model.User;

import java.util.List;

public interface UserRepository {
    User findByUsername(String username);

    User addUser(User user);

    List<User> getAll();
}
