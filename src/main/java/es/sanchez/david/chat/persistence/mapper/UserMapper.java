package es.sanchez.david.chat.persistence.mapper;

import es.sanchez.david.chat.core.model.User;
import es.sanchez.david.chat.persistence.entities.UserEntity;

public class UserMapper {
    public static User map(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getUsername(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getPassword());
    }

    public static UserEntity map(User user){
        return new UserEntity(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getPassword());
    }
}
