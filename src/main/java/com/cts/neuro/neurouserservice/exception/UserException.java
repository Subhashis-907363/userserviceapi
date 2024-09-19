//package com.cts.neuro.neurouserservice.exception;
//
//import lombok.Getter;
//
//public class UserException extends RuntimeException {
//    private static final long serialVersionUID = -1L;
//
//    @Getter
//    private final ExceptionCode exceptionCode;
//
//    public UserException(ExceptionCode exceptionCode) {
//        this.exceptionCode = exceptionCode;
//    }
//
//    public UserException(String message, ExceptionCode exceptionCode) {
//        super(message);
//        this.exceptionCode = exceptionCode;
//    }
//
//    public UserException(String message, Throwable cause, ExceptionCode exceptionCode) {
//        super(message, cause);
//        this.exceptionCode = exceptionCode;
//    }
//
//    public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
//                         ExceptionCode exceptionCode) {
//        super(message, cause, enableSuppression, writableStackTrace);
//        this.exceptionCode = exceptionCode;
//    }
//}
