package es.sanchez.david.chat.websocket.mappers;

import es.sanchez.david.chat.core.model.Message;
import es.sanchez.david.chat.core.model.RoomMessage;
import es.sanchez.david.chat.core.model.UserMessage;
import es.sanchez.david.chat.core.service.rooms.RoomService;
import es.sanchez.david.chat.core.service.user.UserService;
import es.sanchez.david.chat.websocket.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatMessageMapper {
    private UserService userService;
    private RoomService roomService;

    public ChatMessageMapper(UserService userService, RoomService roomService) {
        this.userService = userService;
        this.roomService = roomService;
    }

    public Message map(ChatMessage chatMessage) {
        switch (chatMessage.getDestinationType()) {
            case ROOM:
                return mapRoom(chatMessage);
            case USER:
                return mapUser(chatMessage);
            default:
                throw new IllegalStateException("Destination type unknown");
        }
    }

    public RoomMessage mapRoom(ChatMessage chatMessage) {
        return new RoomMessage(LocalDateTime.now(), chatMessage.getContent(), userService.findUser(chatMessage.getSender()), roomService.findByName(chatMessage.getDestinationId()));
    }

    public UserMessage mapUser(ChatMessage chatMessage) {
        return new UserMessage(LocalDateTime.now(), chatMessage.getContent(), userService.findUser(chatMessage.getSender()), userService.findUser(chatMessage.getDestinationId()));
    }
}
