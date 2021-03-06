package es.sanchez.david.chat.core.service.user;

import es.sanchez.david.chat.core.model.User;
import es.sanchez.david.chat.persistence.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static es.sanchez.david.chat.core.util.PasswordUtil.hashPassword;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean isValidUser(String username, String password) {
        User user = findUser(username);
        return hashPassword(password).equals(user.getPassword());
    }

    @Override
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }
}
