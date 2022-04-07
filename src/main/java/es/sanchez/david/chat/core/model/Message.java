package es.sanchez.david.chat.core.model;

import java.time.LocalDateTime;

public abstract class Message {
    private Long Id;
    private LocalDateTime createdOn;
    private String text;
    private User senderUser;

    public Message(Long id, LocalDateTime createdOn, String text, User senderUser) {
        Id = id;
        this.createdOn = createdOn;
        this.text = text;
        this.senderUser = senderUser;
    }

    public Long getId() {
        return Id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getText() {
        return text;
    }

    public User getSenderUser() {
        return senderUser;
    }
}
