package ua.com.marketplace.backend.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

public record ApiExceptionResponse(HttpStatus status, LocalDateTime timestamp, Map<String, String> causes) {
    public ApiExceptionResponse(HttpStatus status, Map<String, String> causes) {
        this(status, LocalDateTime.now(), causes);
    }
}
