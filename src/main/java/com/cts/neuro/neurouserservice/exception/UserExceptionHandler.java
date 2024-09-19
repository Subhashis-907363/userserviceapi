package com.cts.neuro.neurouserservice.exception;

public class UserExceptionHandler extends Exception {
    public UserExceptionHandler(String message) {
        super(message);
    }
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
//
//        return handleExceptionInternal(ex, responseBody, new HttpHeaders(), status, request);
//    }
}
