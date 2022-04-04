package es.sanchez.david.chat.persistence.repositories.jpa;

import es.sanchez.david.chat.persistence.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomJpaRepository extends JpaRepository<RoomEntity, Long> {
}
