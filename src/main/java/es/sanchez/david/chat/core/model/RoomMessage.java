package es.sanchez.david.chat.core.model;

import java.time.LocalDateTime;

public class RoomMessage extends Message {
    private Room room;

    public RoomMessage(Long id, LocalDateTime createdOn, String text, User senderUser, Room room) {
        super(id, createdOn, text, senderUser);
        this.room = room;
    }

    public RoomMessage(LocalDateTime createdOn, String text, User senderUser, Room room) {
        super(null, createdOn, text, senderUser);
        this.room = room;
    }


    public Room getRoom() {
        return room;
    }
}
