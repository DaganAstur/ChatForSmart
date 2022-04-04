package es.sanchez.david.chat.persistence.repositories.jpa;

import es.sanchez.david.chat.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
       Optional<UserEntity> findByUsername(String username);
}
