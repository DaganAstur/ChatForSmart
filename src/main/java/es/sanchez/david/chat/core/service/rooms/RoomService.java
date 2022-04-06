package es.sanchez.david.chat.core.service.rooms;

import es.sanchez.david.chat.core.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAll();

    Room addRoom(Room room);
}
