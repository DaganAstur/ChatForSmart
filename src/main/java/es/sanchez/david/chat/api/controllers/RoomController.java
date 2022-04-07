package es.sanchez.david.chat.api.controllers;

import es.sanchez.david.chat.api.mappers.RoomMapper;
import es.sanchez.david.chat.api.model.Room;
import es.sanchez.david.chat.core.service.rooms.RoomService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RoomController {
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @Transactional
    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public List<Room> getAll() {
        return roomService.getAll().stream().map(RoomMapper::map).collect(Collectors.toList());
    }

    @Transactional
    @RequestMapping(value = "/rooms", method = RequestMethod.POST)
    public Room addRoom(@RequestBody Room room) {
        return RoomMapper.map(roomService.addRoom(RoomMapper.map(room)));
    }
}
