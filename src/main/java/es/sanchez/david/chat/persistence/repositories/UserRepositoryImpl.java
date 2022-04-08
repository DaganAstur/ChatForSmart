package es.sanchez.david.chat.persistence.repositories;

import es.sanchez.david.chat.core.exception.NotfoundException;
import es.sanchez.david.chat.core.model.User;
import es.sanchez.david.chat.persistence.mapper.UserMapper;
import es.sanchez.david.chat.persistence.repositories.jpa.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userJpaRepository.findByUsername(username).map(UserMapper::map).orElseThrow(() -> new NotfoundException(String.format("User with username %s not found", username)));
    }

    @Override
    public User addUser(User user) {
        return UserMapper.map(userJpaRepository.save(UserMapper.map(user)));
    }

    @Override
    public List<User> getAll() {
        return userJpaRepository.findAll().stream().map(UserMapper::map).collect(Collectors.toList());
    }
}
