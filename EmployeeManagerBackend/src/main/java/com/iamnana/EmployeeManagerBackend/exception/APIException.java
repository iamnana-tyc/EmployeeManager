package com.iamnana.EmployeeManagerBackend.exception;

public class APIException extends RuntimeException {
    public APIException(String message) {
        super(message);
    }
}
