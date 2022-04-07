package es.sanchez.david.chat.persistence.repositories;

import es.sanchez.david.chat.core.model.Room;

import java.util.List;

public interface RoomRepository {
    Room findById(Long id);

    Room findByName(String name);

    Room addRoom(Room room);

    List<Room> getAll();
}
