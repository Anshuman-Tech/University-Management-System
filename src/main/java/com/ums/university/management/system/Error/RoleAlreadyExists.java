package com.ums.university.management.system.Error;

public class RoleAlreadyExists extends Exception{
    public RoleAlreadyExists() {
        super();
    }

    public RoleAlreadyExists(String message) {
        super(message);
    }

    public RoleAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected RoleAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
