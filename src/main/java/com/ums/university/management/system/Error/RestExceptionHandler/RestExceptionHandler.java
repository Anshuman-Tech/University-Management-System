package com.ums.university.management.system.Error.RestExceptionHandler;


import com.ums.university.management.system.DTO.ErrorResponse;
import com.ums.university.management.system.Error.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RoleNotFound.class)
    public ResponseEntity<ErrorResponse> roleNotFound(Exception e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(RoleAlreadyExists.class)
    public ResponseEntity<ErrorResponse> roleAlreadyExists(Exception e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.FOUND)
                .build();
        return ResponseEntity.status(HttpStatus.FOUND).body(errorResponse);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorResponse> userNotFound(Exception e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.FOUND)
                .build();
        return ResponseEntity.status(HttpStatus.FOUND).body(errorResponse);
    }

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<ErrorResponse> userAlreadyExists(Exception e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.FOUND)
                .build();
        return ResponseEntity.status(HttpStatus.FOUND).body(errorResponse);
    }

    @ExceptionHandler(StudentAlreadyExists.class)
    public ResponseEntity<ErrorResponse> studentAlreadyExists(Exception e){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.FOUND)
                .build();
        return new ResponseEntity<>(errorResponse,HttpStatus.FOUND);
    }

}
