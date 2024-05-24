package com.mydom.rest_api_movies.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(
            {
                    NotFoundException.class,
                    NoResourceFoundException.class
            }
    )
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest httpServletRequest, Exception exception) {

        return new ErrorMessage(httpServletRequest.getRequestURI(), exception);
    }
}