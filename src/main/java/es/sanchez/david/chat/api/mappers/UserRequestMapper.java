package es.sanchez.david.chat.api.mappers;

import es.sanchez.david.chat.api.model.UserRequest;
import es.sanchez.david.chat.core.model.User;

import static es.sanchez.david.chat.core.util.PasswordUtil.hashPassword;

public class UserRequestMapper {
    public static User map(UserRequest userRequest){
        return new User(null, userRequest.getUsername(), userRequest.getFirstName(), userRequest.getLastName(), hashPassword(userRequest.getPassword()));
    }
}
