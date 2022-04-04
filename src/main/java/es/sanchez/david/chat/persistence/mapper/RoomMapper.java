package es.sanchez.david.chat.persistence.mapper;

import es.sanchez.david.chat.core.model.Room;
import es.sanchez.david.chat.persistence.entities.RoomEntity;

public class RoomMapper {
    public static Room map(RoomEntity room){
        return new Room(room.getId(), room.getName(), room.getCreatedOn());
    }

    public static RoomEntity map(Room room){
        return new RoomEntity(room.getId(), room.getName(), room.getCreatedOn());
    }
}
