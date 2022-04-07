package es.sanchez.david.chat.persistence.repositories;

import es.sanchez.david.chat.core.model.Message;
import es.sanchez.david.chat.core.model.RoomMessage;
import es.sanchez.david.chat.core.model.UserMessage;
import es.sanchez.david.chat.persistence.mapper.MessageMapper;
import es.sanchez.david.chat.persistence.repositories.jpa.MessageJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private MessageJpaRepository messageJpaRepository;

    public MessageRepositoryImpl(MessageJpaRepository messageJpaRepository) {
        this.messageJpaRepository = messageJpaRepository;
    }

    @Override
    public List<RoomMessage> findRoomMessagesByRoomId(Long id) {
        return messageJpaRepository.findRoomMessageByRoomId(id).stream()
                    .map(MessageMapper::map)
                    .map(RoomMessage.class::cast)
                    .collect(Collectors.toList());
    }

    @Override
    public List<UserMessage> findUserMessagesByUserId(Long id) {
        return messageJpaRepository.findUserMessageByReceiverUserId(id).stream()
                .map(MessageMapper::map)
                .map(UserMessage.class::cast)
                .collect(Collectors.toList());
    }

    @Override
    public Message addMessage(Message message) {
        return MessageMapper.map(messageJpaRepository.save(MessageMapper.map(message)));
    }
}
