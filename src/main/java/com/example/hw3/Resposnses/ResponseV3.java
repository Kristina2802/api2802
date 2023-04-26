package com.example.hw3.Resposnses;

import com.example.hw3.Data.UserResponse;

import java.util.ArrayList;


public record ResponseV3 (
    @Deprecated(forRemoval = true)
    ArrayList<String> login,
    Long count,
    ArrayList<UserResponse> users
    ) {
}
