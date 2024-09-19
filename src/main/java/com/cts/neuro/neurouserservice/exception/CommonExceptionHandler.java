package com.cts.neuro.neurouserservice.exception;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CommonExceptionHandler {
//    @ExceptionHandler(value = {UserException.class})
//    protected ResponseEntity<Object> handleUserServiceException(RuntimeException ex, WebRequest request) {
//
//        String responseBody = "";
//        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
//
//        if (ex instanceof UserException) {
//            UserException userException = (UserException) ex;
//
//            switch (userException.getExceptionCode()) {
//                case USER_NOT_FOUND:
//                    responseBody = userException.getMessage();
//                    status = HttpStatus.NOT_FOUND;
//                    break;
//
//                case DUPLICATE_RECORD:
//                    responseBody = userException.getMessage();
//                    status = HttpStatus.CONFLICT;
//                    break;
//
//                case INTERNAL_SERVER_ERROR:
//                    responseBody = userException.getMessage();
//                    status = HttpStatus.INTERNAL_SERVER_ERROR;
//                    break;
//
//                case INVALID_PASSWORD:
//                    responseBody = userException.getMessage();
//                    status = HttpStatus.BAD_REQUEST;
//                    break;
//
//                default:
//                    break;
//            }
//
//        }

//        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), status, request);
//    }

//    @ExceptionHandler(value = {ValidationException.class})
//    protected ResponseEntity<Object> handleIllegalArgumentException(RuntimeException ex, WebRequest request) {
//        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    @ExceptionHandler(UserExceptionHandler.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,String> handleUserException(UserExceptionHandler ex) {
        Map<String,String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return error;
    }
}
