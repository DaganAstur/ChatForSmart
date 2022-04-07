package es.sanchez.david.chat.core.service.message;

import es.sanchez.david.chat.core.model.Message;
import es.sanchez.david.chat.core.model.RoomMessage;
import es.sanchez.david.chat.core.model.UserMessage;
import es.sanchez.david.chat.persistence.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<RoomMessage> findRoomMessagesByRoomId(Long id) {
        return messageRepository.findRoomMessagesByRoomId(id);
    }

    @Override
    public List<UserMessage> findUserMessagesByUserId(Long id) {
        return messageRepository.findUserMessagesByUserId(id);
    }

    @Override
    public Message addMessage(Message message) {
        return messageRepository.addMessage(message);
    }
}
