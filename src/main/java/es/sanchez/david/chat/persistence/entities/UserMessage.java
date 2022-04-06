package es.sanchez.david.chat.persistence.entities;

import com.sun.istack.NotNull;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("USER")
public class UserMessage extends MessageEntity{
    @ManyToOne
    @NotNull
    @JoinColumn(name = "receiver_user_id")
    private UserEntity receiverUser;

    public UserMessage(UserEntity receiverUser) {
        this.receiverUser = receiverUser;
    }

    public UserMessage(Long id, LocalDateTime createdOn, String text, UserEntity senderUser, String messageType, UserEntity receiverUser) {
        super(id, createdOn, text, senderUser, messageType);
        this.receiverUser = receiverUser;
    }

    public UserEntity getReceiverUser() {
        return receiverUser;
    }
}
