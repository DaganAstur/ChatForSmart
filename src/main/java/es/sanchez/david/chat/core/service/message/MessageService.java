package es.sanchez.david.chat.core.service.message;

import es.sanchez.david.chat.core.model.Message;
import es.sanchez.david.chat.core.model.RoomMessage;
import es.sanchez.david.chat.core.model.UserMessage;

import java.util.List;

public interface MessageService {
    List<RoomMessage> findRoomMessagesByRoomId(Long id);
    List<UserMessage> findUserMessagesByUserId(Long id);

    Message addMessage(Message message);

}
