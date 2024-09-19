package com.cts.neuro.neurouserservice.exception;

public enum ExceptionCode {
    DUPLICATE_RECORD(10001),
    USER_NOT_FOUND(10002),
    INTERNAL_SERVER_ERROR(10005),
    INVALID_PASSWORD(10004);


    private final int errorCode;

    private ExceptionCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

}