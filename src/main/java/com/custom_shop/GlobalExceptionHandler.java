package com.custom_shop;

import java.lang.instrument.IllegalClassFormatException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.hibernate.id.IdentifierGenerationException;
import org.springframework.dao.DataIntegrityViolationException;
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
    String badlyShapedObject(IllegalClassFormatException ex) {
        return ex.getLocalizedMessage();
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resourceNotFound(NoSuchElementException ex) {
        return ex.getLocalizedMessage();
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String SQLIntegrityConstraint(SQLIntegrityConstraintViolationException ex) {
        return ex.getLocalizedMessage();
    }

    @ExceptionHandler(IdentifierGenerationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String idNeeded(IdentifierGenerationException ex) {
        return "Request mal armada, es necesario especificar id : " + ex.getLocalizedMessage();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String validationError(ConstraintViolationException ex) {
        return "No se cumplió el requisito de validación : " + ex.getLocalizedMessage() + "\nNo se creo el recurso";
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String validationError(DataIntegrityViolationException ex) {
        return "No se cumplió el requisito de validación : " + ex.getLocalizedMessage() + "\nNo se creo el recurso";
    }

}
