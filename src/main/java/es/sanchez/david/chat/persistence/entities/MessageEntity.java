package es.sanchez.david.chat.persistence.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="message")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "message_type")
public abstract class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @NotNull
    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "sender_user_id")
    private UserEntity senderUser;

    @Column(name="message_type", insertable = false, updatable = false)
    private String messageType;

    public MessageEntity() {
    }

    public MessageEntity(Long id, LocalDateTime createdOn, String text, UserEntity senderUser, String messageType) {
        this.id = id;
        this.createdOn = createdOn;
        this.text = text;
        this.senderUser = senderUser;
        this.messageType = messageType;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public String getText() {
        return text;
    }

    public UserEntity getSenderUser() {
        return senderUser;
    }

    public String getMessageType() {
        return messageType;
    }
}
