package com.example.hw3.Resposnses;

import java.util.ArrayList;

public record ResponseV2 (
    ArrayList<String> login,
    Long count) {
}
