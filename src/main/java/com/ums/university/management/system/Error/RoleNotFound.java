package com.ums.university.management.system.Error;


public class RoleNotFound extends Exception{

    public RoleNotFound() {
        super();
    }

    public RoleNotFound(String message) {
        super(message);
    }

    public RoleNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public RoleNotFound(Throwable cause) {
        super(cause);
    }

    protected RoleNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
