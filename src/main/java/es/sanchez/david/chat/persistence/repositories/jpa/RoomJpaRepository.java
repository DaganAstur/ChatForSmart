package es.sanchez.david.chat.persistence.repositories.jpa;

import es.sanchez.david.chat.persistence.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomJpaRepository extends JpaRepository<RoomEntity, Long> {
    Optional<RoomEntity> findByName(String name);
}
