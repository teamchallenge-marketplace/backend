package ua.com.marketplace.backend.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ApiResponse(HttpStatus status, LocalDateTime timestamp, Object payload) {
    public ApiResponse(HttpStatus status, Object payload) {
        this(status, LocalDateTime.now(), payload);
    }
}
