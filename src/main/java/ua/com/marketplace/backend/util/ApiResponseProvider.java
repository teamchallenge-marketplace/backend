package ua.com.marketplace.backend.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ua.com.marketplace.backend.dto.ApiExceptionResponse;
import ua.com.marketplace.backend.dto.ApiResponse;

import java.util.Map;

@Component
public class ApiResponseProvider {

    public ResponseEntity<ApiResponse> getApiResponse(HttpStatus status, Object payload) {
        ApiResponse apiResponse = new ApiResponse(status, payload);

        return ResponseEntity.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(apiResponse);
    }

    public ResponseEntity<ApiExceptionResponse> getApiExceptionResponse(HttpStatus status,
                                                                        Map<String, String> causes) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(status, causes);

        return ResponseEntity.status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(apiExceptionResponse);
    }

}
