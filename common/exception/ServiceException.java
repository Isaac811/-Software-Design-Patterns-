package com.work.common.exception;
public class ServiceException extends RuntimeException {
    /**
     * Fault Code
     */
    private Integer code;

    /**
     * Fault Heads Up
     */
    private String message;
    public ServiceException() {
    }

    public ServiceException(String message) {
        this.message = message;
    }

    public ServiceException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
