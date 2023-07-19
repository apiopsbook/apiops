package com.acmepetsupplies.controller;

import com.acmepetsupplies.model.Error;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        Error apiError = new Error();
        apiError.setId(UUID.randomUUID());
        apiError.setStatus(status.value());
        switch (status.series().value()) {
            case 4: apiError.setCode("validation." +
                    status.series().name().toLowerCase());
                break;
            case 5: apiError.setCode("error." +
                    status.series().name().toLowerCase());
                break;
            default:
                apiError.setCode(status.series().name().toLowerCase());
                break;
        }
        apiError.setTitle(status.getReasonPhrase());
        switch (status.value()) {
            case 400: apiError.setDetail("Bad request. Please check the request is valid.");
                break;
            case 404:
                apiError.setDetail("Resource not found. Please check the path and resource identifier in your request");
                break;
            case 429: apiError.setDetail("Too many requests. Request quota exceeded in time window. Try again soon");
                break;
            default: apiError.setDetail(status.getReasonPhrase());
                break;
        }
        return new ResponseEntity<>(apiError, headers, status);
    }
}
