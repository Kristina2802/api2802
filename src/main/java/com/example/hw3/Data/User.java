package com.example.hw3.Data;

public record User(
    Long id,
    String login,
    String name,
    String surname,
    Integer age
) {
}