package es.sanchez.david.chat.persistence.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;


    @Column(name = "name", unique = true)
    private String name;

    public RoomEntity() {
    }

    public RoomEntity(Long id,  String name, LocalDateTime createdOn) {
        this.id = id;
        this.createdOn = createdOn;
        this.name = name;
    }

    public RoomEntity(Long id, String name) {
        this.id = id;
        this.createdOn = LocalDateTime.now();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}
