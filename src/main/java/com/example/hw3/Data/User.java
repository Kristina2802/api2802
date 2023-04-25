package com.example.hw3.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    public String login;
    String name;
    String surname;
    Integer age;
}