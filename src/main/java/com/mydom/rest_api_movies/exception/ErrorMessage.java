package com.mydom.rest_api_movies.exception;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ErrorMessage {
    private final String exception;
    private final String message;
    private final String path;

    public ErrorMessage( String path, Exception e) {
        this.exception = e.getClass().getSimpleName();
        this.message = e.getMessage();
        this.path = path;
    }
}