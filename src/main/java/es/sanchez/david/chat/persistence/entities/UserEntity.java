package es.sanchez.david.chat.persistence.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "password")
    private String password;

    public UserEntity() {
        super();
    }

    public UserEntity(Long id, LocalDateTime createdOn, String username, String firstName, String lastName, String password) {
        this.id = id;
        this.createdOn = createdOn;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public UserEntity(Long id, String username, String firstName, String lastName, String password) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.createdOn = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }
}

