package com.example.outbox.DTOs;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "User")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    Long id;
    public String login;
    public String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
