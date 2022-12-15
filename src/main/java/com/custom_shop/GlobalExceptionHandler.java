package com.custom_shop;

import java.lang.instrument.IllegalClassFormatException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalClassFormatException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String badlyShapedObject(IllegalClassFormatException ex){
        return ex.getLocalizedMessage();
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resourceNotFound(NoSuchElementException ex){
        return ex.getLocalizedMessage();
    }
    
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String SQLIntegrityConstraint(SQLIntegrityConstraintViolationException ex){
        return ex.getLocalizedMessage();
    }
}
