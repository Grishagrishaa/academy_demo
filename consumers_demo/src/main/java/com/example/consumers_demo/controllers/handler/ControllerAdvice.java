package com.example.consumers_demo.controllers.handler;


import com.example.consumers_demo.service.dto.errors.ErrorMessage;
import com.example.consumers_demo.service.dto.errors.StructuredError;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.OptimisticLockException;
import javax.validation.ConstraintViolationException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ControllerAdvice {
    private static final Logger log = LoggerFactory.getLogger(ControllerAdvice.class);


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorMessage handle(IllegalArgumentException e){
        log.warn("{} {}", e.getClass(), e.getMessage());
        return new ErrorMessage(
                e.getMessage()
        );

    }

    @ExceptionHandler(OptimisticLockException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorMessage handle(OptimisticLockException e){
        log.warn("{} {}", e.getClass(), e.getMessage());
        return new ErrorMessage(
                e.getMessage()
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorMessage handle(HttpMessageNotReadableException e){
        log.warn("{} {}", e.getClass(), e.getMessage());
        return new ErrorMessage(
                e.getClass().getSimpleName(), "INVALID INPUT DATA"
        );
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorMessage handle(HttpRequestMethodNotSupportedException e){
        log.warn("{} {}", e.getClass(), e.getMessage());
        return new ErrorMessage(
                "METHOD NOT SUPPORTED ON CURRENT URL | CHECK URL"
        );
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorMessage handle(SQLIntegrityConstraintViolationException e){
        String message = e.getMessage();
        return new ErrorMessage(String.format("%s - user with this email already exists",
                StringUtils.substringBetween(message, "'" )));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    public StructuredError handle(ConstraintViolationException e){
        log.warn("{} {}", e.getClass(), e.getMessage());
        return new StructuredError(e.getConstraintViolations().stream()
                .map(exc -> new ErrorMessage(
                        exc.getPropertyPath().toString().split("\\.")[2],
                        exc.getMessage()))
                .collect(Collectors.toSet()));
    }

}

