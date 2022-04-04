package es.sanchez.david.chat.api.mappers;

import es.sanchez.david.chat.api.model.Room;

public class RoomMapper {
    public static Room map(es.sanchez.david.chat.core.model.Room room) {
        return new Room(room.getId(), room.getName(), room.getCreatedOn());
    }

    public static es.sanchez.david.chat.core.model.Room map(Room room) {
        return new es.sanchez.david.chat.core.model.Room(room.getId(), room.getName(), room.getCreatedOn());
    }
}
