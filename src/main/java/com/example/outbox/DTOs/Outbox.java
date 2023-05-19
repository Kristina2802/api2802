package com.example.outbox.DTOs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Outbox")
@NoArgsConstructor
public class Outbox {
    @Id
    @GeneratedValue
    Long id;
    String login;

    public Outbox(String login) {
        this.login = login;
    }
}
