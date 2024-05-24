package com.mydom.rest_api_movies.exceptions;

public class ErrorMessage {
    private String exception;
    private String message;
    private String path;

    public ErrorMessage( String path, Exception e) {
        this.exception = e.getClass().getSimpleName();
        this.message = e.getMessage();
        this.path = path;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "exception='" + exception + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}