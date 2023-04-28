package com.example.hw3.Requests;

import jakarta.annotation.Nullable;

public record RequestV5 (
    String likeString,
    @Nullable
    String regexpString,
    @Nullable
    String surname,
    @Nullable
    Integer lowAge,
    @Nullable
    Integer upAge) {
}
