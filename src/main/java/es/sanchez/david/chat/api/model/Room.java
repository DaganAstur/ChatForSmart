package es.sanchez.david.chat.api.model;

import java.time.LocalDateTime;

public class Room {
    private Long id;
    private String name;
    private LocalDateTime createdOn;

    public Room() {
    }

    public Room(Long id, String name, LocalDateTime createdOn) {
        this.id = id;
        this.name = name;
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}
