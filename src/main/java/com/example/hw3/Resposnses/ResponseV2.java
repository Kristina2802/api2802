package com.example.hw3.Resposnses;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ResponseV2 {
    private ArrayList<String> login;

    private Long count;

    public ResponseV2() {
        login = new ArrayList<>();
    }
}
