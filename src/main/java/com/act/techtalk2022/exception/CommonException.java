package com.act.techtalk2022.exception;

public abstract class CommonException extends RuntimeException {
    private final String code;

    private final String message;

    protected CommonException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}