package com.ums.university.management.system.Error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class StudentAlreadyExists extends Exception {

    public StudentAlreadyExists() {
        super();
    }

    public StudentAlreadyExists(String message) {
        super(message);
    }

    public StudentAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected StudentAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
