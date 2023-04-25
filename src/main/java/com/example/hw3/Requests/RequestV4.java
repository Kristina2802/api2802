package com.example.hw3.Requests;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestV4 {
    private String likeString;
    @Nullable
    private String regexString;
}
