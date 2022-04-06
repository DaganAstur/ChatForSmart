package es.sanchez.david.chat.persistence.entities;

import com.sun.istack.NotNull;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("ROOM")
public class RoomMessage extends MessageEntity{
    @ManyToOne
    @NotNull
    @JoinColumn(name = "room_id")
    private RoomEntity roomEntity;

    public RoomMessage(RoomEntity roomEntity) {
        this.roomEntity = roomEntity;
    }

    public RoomMessage(Long id, LocalDateTime createdOn, String text, UserEntity senderUser, String messageType, RoomEntity roomEntity) {
        super(id, createdOn, text, senderUser, messageType);
        this.roomEntity = roomEntity;
    }

    public RoomEntity getRoomEntity() {
        return roomEntity;
    }
}
