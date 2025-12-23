package com.iamnana.EmployeeManagerBackend.exception;

import com.iamnana.EmployeeManagerBackend.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<APIResponse> handleResourceNotFoundException(ResourcesNotFoundException e) {
        String message = e.getMessage();
        APIResponse apiResponse = new APIResponse(message, false);

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<APIResponse> handleAPIException(APIException e) {
        String message = e.getMessage();
        APIResponse apiResponse = new APIResponse(message, false);

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
