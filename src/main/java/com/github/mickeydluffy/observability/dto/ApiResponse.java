package com.github.mickeydluffy.observability.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiResponse<T> {
    private HttpStatus httpStatus;
    private T response;
}
