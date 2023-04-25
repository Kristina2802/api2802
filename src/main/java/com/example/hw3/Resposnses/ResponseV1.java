package com.example.hw3.Resposnses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ResponseV1 {
    private ArrayList<String> login;

    public ResponseV1() {
        login = new ArrayList<>();
    }
}
