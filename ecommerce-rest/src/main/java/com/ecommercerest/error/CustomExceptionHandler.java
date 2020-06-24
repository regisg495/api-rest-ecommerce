package com.ecommercerest.error;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({UsernameNotFoundException.class, BadCredentialsException.class})
    public final ResponseEntity<CustomErrorResponse> handleAcessDeniedException
            (Exception ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("ACESS DENIED", details, "403", Calendar.getInstance());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({ConversionFailedException.class, NumberFormatException.class, IllegalArgumentException.class})
    public final ResponseEntity<CustomErrorResponse> handleConversionFailedException
            (Exception ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("INTERNAL_SERVER_ERROR", details, "500", Calendar.getInstance());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({StorageEmptyFileException.class, FieldsTempateNotFoundException.class})
    public final ResponseEntity<CustomErrorResponse> handleStorageEmptyFileException
            (Exception ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("BAD_REQUEST", details, "400", Calendar.getInstance());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({FieldValueAlreadyExistsException.class, ParentRowDeleteException.class})
    public final ResponseEntity<CustomErrorResponse> handleFieldValueAlreadyExistsException
            (DataIntegrityViolationException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("CONFLICT", details, "409", Calendar.getInstance());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({EntityNotFoundException.class, StorageFileNotFoundException.class, NoSuchElementException.class})
    public final ResponseEntity<CustomErrorResponse> handleEntityNotFoundException
            (Exception ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("NOT_FOUND", details, "404", Calendar.getInstance());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<CustomErrorResponse> handleHttpMessageNotReadableException
            (HttpMessageNotReadableException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("BAD_REQUEST", details, "400", Calendar.getInstance());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<CustomErrorResponse> handleMethodArgumentNotValidException
            (MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        final List<ObjectError> objectErrors = result.getAllErrors();
        List<String> details = objectErrors.stream().map(objectError -> objectError.getObjectName() + ": " +
                objectError.getDefaultMessage()).collect(Collectors.toList());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("BAD_REQUEST", details, "400", Calendar.getInstance());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public final ResponseEntity<CustomErrorResponse> handleMethodNotAllowedException
            (MethodNotAllowedException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("METHOD_NOT_ALLOWED", details, "405", Calendar.getInstance());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public final ResponseEntity<CustomErrorResponse> handleHttpRequestMethodNotSupportedException
            (HttpRequestMethodNotSupportedException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("METHOD_NOT_ALLOWED", details, "405", Calendar.getInstance());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<CustomErrorResponse> handleConstraintViolationException
            (ConstraintViolationException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        CustomErrorResponse error = new CustomErrorResponse("BAD_REQUEST", details, "400", Calendar.getInstance());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<CustomErrorResponse> handleDataIntegrityViolationException
            (DataIntegrityViolationException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getRootCause().getMessage());
        CustomErrorResponse error = new CustomErrorResponse("CONFLICT", details, "409", Calendar.getInstance());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

}
