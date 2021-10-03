package com.acko.ackoservice.exception;

public class UserBadCredentialsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UserBadCredentialsException(String message) {
        super(message);
    }

}
