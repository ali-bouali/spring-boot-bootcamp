package com.alibou.demo.handlers;

import com.alibou.demo.exception.StudentAssignmentException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exp) {
        var validationErrors = new HashSet<String>();
        for(ObjectError error : exp.getBindingResult().getAllErrors()) {
            var errorMsg = error.getDefaultMessage();
            validationErrors.add(String.format("%s", errorMsg));
        }
        var errorResponse = ErrorResponse.builder()
                .errorMsg("Object not valid")
                .validationErrors(validationErrors)
                .build();

        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(EntityNotFoundException exp) {
        var errorResponse = ErrorResponse.builder()
                .errorMsg(exp.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .body(errorResponse);
    }

    @ExceptionHandler(StudentAssignmentException.class)
    public ResponseEntity<ErrorResponse> handleException(StudentAssignmentException exp) {
        var errorResponse = ErrorResponse.builder()
                .errorMsg(exp.getMessage())
                .build();
        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleException(BadCredentialsException exp) {
        var errorResponse = ErrorResponse.builder()
                .errorMsg("Login and / or password is incorrect")
                .build();
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(errorResponse);
    }
}
