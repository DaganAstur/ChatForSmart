package es.sanchez.david.chat.websocket.model;

import es.sanchez.david.chat.websocket.model.enums.DestinationType;

public class ChatMessage {
    private MessageType messageType;
    private String content;
    private String sender;
    private String time;
    private DestinationType destinationType;
    private String destinationId;


    public ChatMessage(MessageType messageType, String content, String sender, String time, DestinationType destinationType, String destinationId) {
        this.messageType = messageType;
        this.content = content;
        this.sender = sender;
        this.time = time;
        this.destinationType = destinationType;
        this.destinationId = destinationId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getTime() {
        return time;
    }

    public DestinationType getDestinationType() {
        return destinationType;
    }

    public String getDestinationId() {
        return destinationId;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "messageType=" + messageType +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", time='" + time + '\'' +
                ", destinationType=" + destinationType +
                ", destinationId='" + destinationId + '\'' +
                '}';
    }
}
