package com.example.hw3.Data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private String login;
    private String name;
    private String surname;
}
