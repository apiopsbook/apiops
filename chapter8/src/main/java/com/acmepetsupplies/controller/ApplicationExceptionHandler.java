package com.acmepetsupplies.controller;

import com.acmepetsupplies.model.Error;
import com.acmepetsupplies.model.ErrorErrorsInner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.setContentType(new MediaType("application", "vnd.api+json"));
        ErrorErrorsInner errorsInner = new ErrorErrorsInner(status.series().value(), status.getReasonPhrase());
        errorsInner.setId(UUID.randomUUID());
        errorsInner.setStatus(status.value());
        errorsInner.setTitle(status.getReasonPhrase());
        switch (status.value()) {
            case 400 -> {
                errorsInner.setDetail("Bad request. Please check the request is valid.");
                errorsInner.setCode("400.001.01");
            }
            case 404 -> {
                errorsInner.setDetail("Resource not found. Please check the path and resource identifier in your request");
                errorsInner.setCode("404.001.01");
            }
            case 429 -> {
                errorsInner.setDetail("Too many requests. Request quota exceeded in time window. Try again soon");
                errorsInner.setCode("429.001.01");
            }
            default -> errorsInner.setDetail(status.getReasonPhrase());
        }
        Error apiError = new Error();
        apiError.addErrorsItem(errorsInner);
        return new ResponseEntity<>(apiError, headers, status);
    }


}