package com.ums.university.management.system.Error;

public class StudentNotFound extends Exception{
    public StudentNotFound() {
        super();
    }

    public StudentNotFound(String message) {
        super(message);
    }

    public StudentNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFound(Throwable cause) {
        super(cause);
    }

    protected StudentNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
