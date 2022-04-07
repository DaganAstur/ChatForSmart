package es.sanchez.david.chat.core.model;

import java.time.LocalDateTime;

public class UserMessage extends Message {
    private User receiverUser;

    public UserMessage(Long id, LocalDateTime createdOn, String text, User senderUser, User receiverUser) {
        super(id, createdOn, text, senderUser);
        this.receiverUser = receiverUser;
    }

    public UserMessage(LocalDateTime createdOn, String text, User senderUser, User receiverUser) {
        super(null, createdOn, text, senderUser);
        this.receiverUser = receiverUser;
    }

    public User getReceiverUser() {
        return receiverUser;
    }
}
