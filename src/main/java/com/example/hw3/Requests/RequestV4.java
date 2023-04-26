package com.example.hw3.Requests;

import jakarta.annotation.Nullable;

public record RequestV4 (
    String likeString,
    @Nullable
    String regexString) {
}
