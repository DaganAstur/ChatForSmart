package es.sanchez.david.chat.api.controllers;

import es.sanchez.david.chat.api.mappers.UserRequestMapper;
import es.sanchez.david.chat.api.model.UserRequest;
import es.sanchez.david.chat.core.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class PublicController {
    private UserService userService;

    @Autowired
    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    @RequestMapping(value = "/public/user", method = RequestMethod.POST)
    public void user(@RequestBody UserRequest userRequest) {
        userService.addUser(UserRequestMapper.map(userRequest));
    }
}
