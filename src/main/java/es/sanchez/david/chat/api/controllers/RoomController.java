package es.sanchez.david.chat.api.controllers;

import es.sanchez.david.chat.api.mappers.RoomMapper;
import es.sanchez.david.chat.api.model.Room;
import es.sanchez.david.chat.core.service.user.RoomService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
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
}
