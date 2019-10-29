package com.fcgl.madrid.search.controller.exceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fcgl.madrid.search.payload.InternalStatus;
import com.fcgl.madrid.search.payload.StatusCode;
import com.fcgl.madrid.search.payload.response.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{


    @Override
    protected ResponseEntity<Object> handleBindException(
            BindException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return genericErrorHandler(ex, ex.getBindingResult(), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return genericErrorHandler(ex, ex.getBindingResult(), headers, status, request);

    }

    private ResponseEntity<Object> genericErrorHandler(
            Exception ex,
            BindingResult bindingResult,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            errors.add(error.getField() + " " + error.getDefaultMessage());
        }
        for (ObjectError error : bindingResult.getGlobalErrors()) {
            errors.add(error.getObjectName() + " " + error.getDefaultMessage());
        }

        InternalStatus internalStatus = new InternalStatus(StatusCode.PARAM, HttpStatus.BAD_REQUEST, errors);
        Response loginResponse = new Response<>(internalStatus, null);
        return handleExceptionInternal(
                ex, loginResponse, headers, internalStatus.getHttpCode(), request);
    }

}

