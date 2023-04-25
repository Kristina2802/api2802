package com.example.hw3.Resposnses;

import com.example.hw3.Data.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ResponseV3 {
    @Deprecated(forRemoval = true)
    private ArrayList<String> login;

    private Long count;

    private ArrayList<UserResponse> users;

    public ResponseV3() {
        login = new ArrayList<>();
        users = new ArrayList<>();
    }
}
