package com.example.abnerlucss.msvembarque.exception;

public class DeleteException extends Exception {

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Exception e) {
        super(message, e);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }
}
