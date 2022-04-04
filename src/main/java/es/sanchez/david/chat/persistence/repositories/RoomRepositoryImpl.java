package es.sanchez.david.chat.persistence.repositories;

import es.sanchez.david.chat.core.exception.NotfoundException;
import es.sanchez.david.chat.core.model.Room;
import es.sanchez.david.chat.persistence.mapper.RoomMapper;
import es.sanchez.david.chat.persistence.repositories.jpa.RoomJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoomRepositoryImpl implements RoomRepository {
    private RoomJpaRepository roomJpaRepository;

    public RoomRepositoryImpl(RoomJpaRepository roomJpaRepository) {
        this.roomJpaRepository = roomJpaRepository;
    }

    @Override
    public Room findById(Long id) {
        return roomJpaRepository.findById(id).map(RoomMapper::map).orElseThrow(() -> new NotfoundException(String.format("Room with id %s not found", id)));
    }

    @Override
    public Room addRoom(Room room) {
        return RoomMapper.map(roomJpaRepository.save(RoomMapper.map(room)));
    }

    @Override
    public List<Room> getAll(){
        return roomJpaRepository.findAll().stream().map(RoomMapper::map).collect(Collectors.toList());
    }
}
