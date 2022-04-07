package es.sanchez.david.chat.persistence.mapper;

import es.sanchez.david.chat.core.model.Message;
import es.sanchez.david.chat.core.model.RoomMessage;
import es.sanchez.david.chat.core.model.UserMessage;
import es.sanchez.david.chat.persistence.entities.MessageEntity;
import es.sanchez.david.chat.persistence.entities.RoomMessageEntity;
import es.sanchez.david.chat.persistence.entities.UserMessageEntity;

public class MessageMapper {
    public static Message map(MessageEntity messageEntity) {
        if (messageEntity instanceof UserMessageEntity) {
            return map((UserMessageEntity) messageEntity);
        }
        if (messageEntity instanceof RoomMessageEntity) {
            return map((RoomMessageEntity) messageEntity);
        }

        throw new IllegalStateException("Unexpected message type");
    }

    private static UserMessage map(UserMessageEntity userMessageEntity) {
        return new UserMessage(userMessageEntity.getId(),
                userMessageEntity.getCreatedOn(),
                userMessageEntity.getText(),
                UserMapper.map(userMessageEntity.getSenderUser()),
                UserMapper.map(userMessageEntity.getReceiverUser()));
    }

    private static RoomMessage map(RoomMessageEntity roomMessageEntity) {
        return new RoomMessage(roomMessageEntity.getId(),
                roomMessageEntity.getCreatedOn(),
                roomMessageEntity.getText(),
                UserMapper.map(roomMessageEntity.getSenderUser()),
                RoomMapper.map(roomMessageEntity.getRoom()));
    }

    // From model to entity
    public static MessageEntity map(Message message) {
        if (message instanceof UserMessage) {
            return map((UserMessage) message);
        }
        if (message instanceof RoomMessage) {
            return map((RoomMessage) message);
        }

        throw new IllegalStateException("Unexpected message type");
    }

    // TODO CHANGE MESSAGE TYPE INTO ENUM OR ADD STRINGS TO CONSTANT
    private static UserMessageEntity map(UserMessage userMessage) {
        return new UserMessageEntity(userMessage.getId(),
                userMessage.getCreatedOn(),
                userMessage.getText(),
                UserMapper.map(userMessage.getSenderUser()),
                "USER",
                UserMapper.map(userMessage.getReceiverUser()));
    }

    private static RoomMessageEntity map(RoomMessage roomMessage) {
        return new RoomMessageEntity(roomMessage.getId(),
                roomMessage.getCreatedOn(),
                roomMessage.getText(),
                UserMapper.map(roomMessage.getSenderUser()),
                "ROOM",
                RoomMapper.map(roomMessage.getRoom()));
    }
}
