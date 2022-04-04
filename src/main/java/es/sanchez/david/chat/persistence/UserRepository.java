package es.sanchez.david.chat.persistence;

import es.sanchez.david.chat.core.model.User;

public interface UserRepository {
    User findByUsername(String username);

    User addUser(User user);
}
