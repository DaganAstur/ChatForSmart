package es.sanchez.david.chat.core.service.rooms;

import es.sanchez.david.chat.core.model.Room;
import es.sanchez.david.chat.persistence.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.getAll();
    }

    @Override
    public Room addRoom(Room room){
        return roomRepository.addRoom(room);
    }
}
