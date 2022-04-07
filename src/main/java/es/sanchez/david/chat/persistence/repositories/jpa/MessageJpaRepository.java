package es.sanchez.david.chat.persistence.repositories.jpa;

import es.sanchez.david.chat.persistence.entities.MessageEntity;
import es.sanchez.david.chat.persistence.entities.RoomEntity;
import es.sanchez.david.chat.persistence.entities.RoomMessageEntity;
import es.sanchez.david.chat.persistence.entities.UserMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageJpaRepository extends JpaRepository<MessageEntity, Long> {
    List<UserMessageEntity> findUserMessageByReceiverUserId(Long id);
    List<RoomMessageEntity> findRoomMessageByRoomId(Long id);
}
